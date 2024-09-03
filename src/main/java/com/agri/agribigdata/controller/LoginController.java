package com.agri.agribigdata.controller;

import com.agri.agribigdata.entity.query.UserVQuery;
import com.agri.agribigdata.exception.CustomException;
import com.agri.agribigdata.service.UserService;
import com.agri.agribigdata.entity.bo.UserBO;
import com.agri.agribigdata.entity.query.UserPQuery;
import com.agri.agribigdata.entity.vo.ResultVO;
import com.agri.agribigdata.utils.JwtUtils;
import com.agri.agribigdata.utils.PasswordUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/login/password")
    public ResultVO login(@RequestBody UserPQuery userPQuery) throws CustomException {
        UserBO userBO = userService.loginWithPassword(userPQuery);
        if(userBO == null){
            throw new CustomException(401,"用户名不存在");
        }
        if(!PasswordUtils.check(userPQuery.getPassword(),userBO.getPassword())){
            throw new CustomException(401,"密码错误");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("username",userPQuery.getUsername());
        claims.put("password",userPQuery.getPassword());
        return ResultVO.success(JwtUtils.generateJwt(claims));
    }

    @PostMapping("/login/sendvcode")
    public ResultVO sendVCode(@RequestBody UserVQuery userVQuery) throws CustomException{
        if((userVQuery.getTel()==null || userVQuery.getTel()=="") && (userVQuery.getEmail()==null || userVQuery.getEmail()!="")){
            throw new CustomException(401, "邮箱和电话号码至少要填写一个");
        }
        if(userVQuery.getEmail()!=null && userVQuery.getEmail()!="" && userService.isDuplicatedEmail(UserBO.transferUserVQ2B(userVQuery))==false){
            throw new CustomException(404, "该邮箱未注册用户");
        }
        if(userVQuery.getTel()!=null &&userVQuery.getTel()!="" && userService.isDuplicatedTel(UserBO.transferUserVQ2B(userVQuery))==false){
            throw new CustomException(404, "该手机号未注册用户");
        }
        if(userVQuery.getEmail()!=null && userVQuery.getEmail()!=""){
            userService.sendEmail(userVQuery.getEmail());
        }
        if(userVQuery.getTel()!=null && userVQuery.getTel()!=""){
            userService.sendSms(userVQuery.getTel());
        }
        return ResultVO.success();
    }

    @PostMapping("/login/checkvcode")
    public ResultVO checkVCode(@RequestBody UserVQuery userVQuery) throws CustomException{
        if(userVQuery.getTel()==null && userVQuery.getEmail()==null){
            throw new CustomException(401, "邮箱和电话号码至少要填写一个");
        }
        if(userVQuery.getVcode()==null){
            throw new CustomException(401, "验证码未填写");
        }
        userService.loginWithVCode(userVQuery);
        return ResultVO.success();
    }
}
