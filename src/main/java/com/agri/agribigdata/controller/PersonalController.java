package com.agri.agribigdata.controller;

import com.agri.agribigdata.entity.query.PersonalQuery;
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
public class PersonalController {
    @Autowired
    UserService userService;

    @PostMapping("/setpersonal")
    public ResultVO setPersonal(@RequestBody PersonalQuery personalQuery) throws CustomException {
        userService.setPersonal(personalQuery);
        return new ResultVO().success();
    }
}
