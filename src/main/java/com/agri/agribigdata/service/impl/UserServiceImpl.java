package com.agri.agribigdata.service.impl;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.agri.agribigdata.config.VerifyConfig;
import com.agri.agribigdata.entity.po.UserPO;
import com.agri.agribigdata.entity.query.PersonalQuery;
import com.agri.agribigdata.entity.query.UserVQuery;
import com.agri.agribigdata.exception.CustomException;
import com.agri.agribigdata.mapper.UserMapper;
import com.agri.agribigdata.service.UserService;
import com.agri.agribigdata.entity.bo.UserBO;
import com.agri.agribigdata.entity.query.UserPQuery;
import com.agri.agribigdata.utils.PasswordUtils;
import com.agri.agribigdata.utils.VCodeUtils;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            throw new CustomException(400, String.format("重复的用户名%s",userBO.getUsername()), "该用户名已注册过本系统");
        }else if(isDuplicatedTel(userBO)){
            throw new CustomException(400, String.format("重复的电话号码%s",userBO.getTel()), "该电话号码已注册过本系统, 不可重复注册");
        }else if(isDuplicatedEmail(userBO)){
            throw new CustomException(400, String.format("重复的邮箱%s", userBO.getEmail()), "该邮箱已注册过本系统, 不可重复注册");
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
    public UserPO loginWithPassword(UserPQuery userPQuery) {
        return userMapper.getByUsername(userPQuery);
    }

    public void loginWithVCode(UserVQuery userVQuery) throws CustomException {
        UserBO userBO = new UserBO();
        if(userVQuery.getEmail()!=null && userVQuery.getEmail()!=""){
            userBO = userMapper.getByEmail(userVQuery);
            if(userBO==null){
                throw new CustomException(404, String.format("未注册的邮箱%s尝试登录", userVQuery.getEmail()), "该邮箱未注册本系统");
            }
            if(!PasswordUtils.check(userVQuery.getVcode(),userBO.getVerifyCode())){
                throw new CustomException(401,String.format("%s尝试登录, 但验证码错误", userVQuery.getEmail()), "验证码错误");
            }
            if(Duration.between(userBO.getVerifyTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), LocalDateTime.now()).toMinutes() > verifyConfig.getVerifyMinutes()){
                throw new CustomException(401,String.format("%s尝试登录, 但验证码错误", userVQuery.getEmail()), "验证码已过期");
            }
            }

        if(userVQuery.getTel()!=null && userVQuery.getTel()!=""){
            userBO = userMapper.getByTel(userVQuery);
            if(userBO==null){
                throw new CustomException(404,String.format("未注册的手机号码%s尝试登录", userVQuery.getTel()), "该手机号码未注册本系统");
            }
            if(!PasswordUtils.check(userVQuery.getVcode(),userBO.getVerifyCode())){
                throw new CustomException(401,String.format("%s尝试登录, 但验证码错误", userVQuery.getTel()), "验证码错误");
            }
            if(Duration.between(userBO.getVerifyTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), LocalDateTime.now()).toMinutes() > verifyConfig.getVerifyMinutes()){
                throw new CustomException(401,String.format("%s尝试登录, 但验证码错误", userVQuery.getTel()), "验证码已过期");
            }
        }

    }

    @Override
    public void sendEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        Integer code = VCodeUtils.VCodeGenerator();
        userMapper.updateVerifyInfoByEmail(PasswordUtils.encrypt(code.toString()), LocalDateTime.now().toString(), to);
        message.setSubject("【南山村网站】您的验证码");
        message.setText("您的验证码是: " + code +", 该验证码" + verifyConfig.getVerifyDescription() + "内有效, 请及时完成登录。若不是本人操作请忽略此邮件。");
        message.setFrom("agriBigData@163.com");
        message.setTo(to);
        javaMailSender.send(message);
    }

    @Override
    public void sendSms(String tel) {
        //验证码
        String content = "code:" + VCodeUtils.VCodeGenerator().toString();
        //模板ID。（联系客服申请。测试ID请用：908e94ccf08b4476ba6c876d13f084ad，短信内容为 { 验证码：**code**，**minute**分钟内有效，请勿泄漏于他人！}）
        String templateId="CST_ptdie100";
        //应用code
        String appCode="39a5cc01d43246c98e866f417f0a0d80";

        //请求连接
        String host = "https://dfsns.market.alicloudapi.com/data/send_sms";
        //拼装请求体
        Map<String, Object> querys = new HashMap<String, Object>();
        querys.put("content", content);
        querys.put("phone_number", tel);
        querys.put("template_id", templateId);

        userMapper.updateVerifyInfoByTel(PasswordUtils.encrypt(content.split(":")[1].trim()), LocalDateTime.now().toString(), tel);

        String result = HttpRequest.post(host)
                .header(Header.AUTHORIZATION, "APPCODE " + appCode)//头信息，多个头信息多次调用此方法即可
                .form(querys)//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();
        System.out.println(result);

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

    @Override
    public UserBO getPersonalInfo(UserPO userPO) throws CustomException {
        if(userPO==null){
            throw new CustomException(404,"用户不存在","用户不存在");
        }
        if(StringUtils.isBlank(userPO.getId())){
            userPO.setId(userMapper.getIdByUsername(userPO.getUsername()));
            userPO.setPrvc(userMapper.getPrvcByUsername(userPO.getUsername()));
        }
        List<String> pzList = userMapper.getInterestedPzList(userPO.getId());
        return UserBO.transferUserP2B(userPO,pzList);
    }


}
