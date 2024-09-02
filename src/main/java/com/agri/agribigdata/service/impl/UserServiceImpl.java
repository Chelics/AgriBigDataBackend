package com.agri.agribigdata.service.impl;

import com.agri.agribigdata.config.VerifyConfig;
import com.agri.agribigdata.entity.query.PersonalQuery;
import com.agri.agribigdata.entity.query.UserVQuery;
import com.agri.agribigdata.exception.CustomException;
import com.agri.agribigdata.mapper.UserMapper;
import com.agri.agribigdata.service.UserService;
import com.agri.agribigdata.entity.bo.UserBO;
import com.agri.agribigdata.entity.query.UserPQuery;
import com.agri.agribigdata.utils.PasswordUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VerifyConfig verifyConfig;
    @Resource
    JavaMailSender javaMailSender;
    @Override
    public void register(UserBO userBO) throws CustomException {
        if(isDuplicatedUsername(userBO)){
            throw new CustomException(400,"重复的用户名");
        }else if(isDuplicatedTel(userBO)){
            throw new CustomException(400,"该电话号码已注册过本系统, 不可重复注册");
        }else if(isDuplicatedEmail(userBO)){
            throw new CustomException(400,"该邮箱已注册过本系统, 不可重复注册");
        }else{
            userMapper.register(userBO);
        }
    }

    @Override
    public boolean isDuplicatedUsername(UserBO userBO){
        return userMapper.checkDoubleUsername(userBO);
    }

    @Override
    public boolean isDuplicatedTel(UserBO userBO){
        return userMapper.checkDoubleTel(userBO);
    }

    @Override
    public boolean isDuplicatedEmail(UserBO userBO){
        return userMapper.checkDoubleEmail(userBO);
    }


    @Override
    public UserBO loginWithPassword(UserPQuery userPQuery) {
        return userMapper.getByUsername(userPQuery);
    }

    public void loginWithVCode(UserVQuery userVQuery) throws CustomException {
        if(userVQuery.getEmail()!=null){
            UserBO userBO = userMapper.getByEmail(userVQuery);
            if(userBO==null){
                throw new CustomException(404,"该邮箱未注册本系统");
            }
            if(!PasswordUtils.check(userVQuery.getVcode(),userBO.getVerifyCode())){
                throw new CustomException(401,"验证码错误");
            }
            if(Duration.between(userBO.getVerifyTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), LocalDateTime.now()).toMinutes() > verifyConfig.getVerifyMinutes()){
                throw new CustomException(401,"验证码已过期");
            }

        }
    }

    @Override
    public void sendEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();

        Random random = new Random();
        Integer code = random.nextInt(89999) + 10000;
        userMapper.updateVerifyInfo(PasswordUtils.encrypt(code.toString()), LocalDateTime.now().toString(), to);
        message.setSubject("【南山村网站】您的验证码");
        message.setText("您的验证码是: " + code +", 该验证码" + verifyConfig.getVerifyDescription() + "内有效, 请及时完成登录。若不是本人操作请忽略此邮件。");
        message.setFrom("agriBigData@163.com");
        message.setTo(to);
        javaMailSender.send(message);
    }


    @Override
    public void setPersonal(PersonalQuery personalQuery) throws CustomException {
        String userId = userMapper.getIdByUsername(personalQuery.getUsername());
        if(userId == null){
            throw new CustomException(404,"用户不存在");
        }
        userMapper.setPrcv(userId, personalQuery.getPrvc());
        List<String> pzList = personalQuery.getPzList();
        if(pzList == null){
            throw new CustomException(400,"品种列表为空");
        }else{
            userMapper.clearPersonalPz(userId);
            for (String pz : personalQuery.getPzList()) {
                userMapper.setPz(userId,pz);
            }
        }
    }

}
