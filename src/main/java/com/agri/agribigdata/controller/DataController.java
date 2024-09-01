package com.agri.agribigdata.controller;

import com.agri.agribigdata.entity.vo.ResultVO;
import com.agri.agribigdata.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DataController {
    @Autowired
    DataService dataService;

    @GetMapping("/data")
    public ResultVO getAllData(){
        return ResultVO.success(dataService.getData());
    }
}
