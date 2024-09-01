package com.agri.agribigdata.controller;


import com.agri.agribigdata.entity.query.PrvcQuery;
import com.agri.agribigdata.entity.vo.ResultVO;
import com.agri.agribigdata.service.PrvcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PrvcController {
    @Autowired
    PrvcService prvcService;

    @PostMapping("/prvc")
    public ResultVO getQueryPrvc(@RequestBody PrvcQuery prvcQuery){
        return ResultVO.success(prvcService.getQuery(prvcQuery.getName()));
    }
}
