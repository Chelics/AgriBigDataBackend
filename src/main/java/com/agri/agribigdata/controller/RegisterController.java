package com.agri.agribigdata.controller;

import com.agri.agribigdata.entity.bo.UserBO;
import com.agri.agribigdata.entity.query.UserRQuery;
import com.agri.agribigdata.entity.vo.ResultVO;
import com.agri.agribigdata.exception.CustomException;
import com.agri.agribigdata.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RegisterController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResultVO register(@RequestBody UserRQuery userRQuery) throws Exception {
        if((userRQuery.getUsername() == null || userRQuery.getUsername() == "")|| (userRQuery.getPassword() == null || userRQuery.getPassword() == "")
                || (userRQuery.getEmail() == null || userRQuery.getEmail() == "") && (userRQuery.getTel() == null || userRQuery.getTel() == "")) {
            return ResultVO.error(400, "必填项未填写完整");
        }

        userService.register(UserBO.transferUserRQ2B(userRQuery));
        return ResultVO.success();
    }

}
