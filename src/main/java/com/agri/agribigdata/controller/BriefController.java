package com.agri.agribigdata.controller;

import com.agri.agribigdata.entity.query.EnterpriseBriefQuery;
import com.agri.agribigdata.entity.query.MarketBriefQuery;
import com.agri.agribigdata.entity.vo.ResultVO;
import com.agri.agribigdata.service.BriefService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BriefController {
    @Autowired
    BriefService briefService;
    @PostMapping("/brief/market")
    public ResultVO getMarketBrief(@RequestBody MarketBriefQuery marketBriefQuery){
        return ResultVO.success(briefService.getMarketBrief(marketBriefQuery));
    }

    @PostMapping("/brief/enterprise")
    public ResultVO getEnterpriseBrief(@RequestBody EnterpriseBriefQuery enterpriseBriefQuery){
        return ResultVO.success(briefService.getEnterpriseBrief(enterpriseBriefQuery));
    }
}
