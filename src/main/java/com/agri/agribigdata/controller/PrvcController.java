package com.agri.agribigdata.controller;


import com.agri.agribigdata.entity.vo.ResultVO;
import com.agri.agribigdata.service.PrvcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PrvcController {
    @Autowired
    PrvcService prvcService;

    @GetMapping("/prvc")
    public ResultVO getQueryPrvc(@RequestParam String name){
        return ResultVO.success(prvcService.getQuery(name));
    }
}
