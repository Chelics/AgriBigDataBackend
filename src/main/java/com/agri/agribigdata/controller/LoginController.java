package com.agri.agribigdata.controller;

import com.agri.agribigdata.exception.CustomException;
import com.agri.agribigdata.service.UserService;
import com.agri.agribigdata.entity.bo.UserBO;
import com.agri.agribigdata.entity.query.UserPQuery;
import com.agri.agribigdata.entity.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/login/password")
    public ResultVO login(@RequestBody UserPQuery userPQuery) throws CustomException {
        UserBO userBO = userService.login(userPQuery);
        if(userBO == null){
            throw new CustomException(401,"用户名或密码错误");
        }
        return ResultVO.success();
    }

}
