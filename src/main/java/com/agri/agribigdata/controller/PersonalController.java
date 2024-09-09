package com.agri.agribigdata.controller;

import com.agri.agribigdata.entity.bo.UserBO;
import com.agri.agribigdata.entity.po.UserPO;
import com.agri.agribigdata.entity.query.PersonalQuery;
import com.agri.agribigdata.entity.vo.PersonalVO;
import com.agri.agribigdata.entity.vo.ResultVO;
import com.agri.agribigdata.exception.CustomException;
import com.agri.agribigdata.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@CrossOrigin
public class PersonalController {
    @Autowired
    UserService userService;

    @PostMapping("/setpersonal")
    public ResultVO setPersonal(@RequestBody PersonalQuery personalQuery) throws CustomException {
        userService.setPersonal(personalQuery);
        return new ResultVO().success();
    }

    @PostMapping("/getpersonal")
    public ResultVO getPersonal(@RequestBody PersonalQuery personalQuery) throws CustomException {
        UserPO userPO = new UserPO();
        userPO.setUsername(personalQuery.getUsername());
        UserBO userBO = userService.getPersonalInfo(userPO);
        return new ResultVO().success(PersonalVO.transferB2V(userBO));
    }
}
