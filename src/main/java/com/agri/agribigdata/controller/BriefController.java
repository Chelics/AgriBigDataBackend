package com.agri.agribigdata.controller;

import com.agri.agribigdata.entity.nc.EnterpriseNC;
import com.agri.agribigdata.entity.po.EnterprisePO;
import com.agri.agribigdata.entity.query.EnterpriseBriefQuery;
import com.agri.agribigdata.entity.query.MarketBriefQuery;
import com.agri.agribigdata.entity.vo.EnterpriseBriefVO;
import com.agri.agribigdata.entity.vo.ResultVO;
import com.agri.agribigdata.service.BriefService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class BriefController {
    @Autowired
    BriefService briefService;
    @PostMapping("/brief/market")
    public ResultVO getMarketBrief(@RequestBody MarketBriefQuery marketBriefQuery){
        return ResultVO.success(briefService.getMarketBrief(marketBriefQuery));
    }

    @PostMapping("/brief/enterprise")
    public ResultVO getEnterpriseBrief(@RequestBody EnterpriseBriefQuery enterpriseBriefQuery){
        EnterpriseBriefVO enterpriseBriefVO = briefService.getEnterpriseBrief(enterpriseBriefQuery);

        List<EnterprisePO> list = enterpriseBriefVO.getEnterpriseList();

        int totalSize = list.size();
        int sublistSize = (int)Math.ceil((double) totalSize / 3);

        ArrayList<ArrayList<EnterprisePO>> newlist = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            int start = i * sublistSize;
            int end = Math.min(start + sublistSize, totalSize);

            List<EnterprisePO> sublist = list.subList(start, end);
            ArrayList<EnterprisePO> rowList = new ArrayList<>(sublist);
            newlist.add(rowList);
        }

        EnterpriseNC enterpriseNC = new EnterpriseNC();
        enterpriseNC.setEnterpriseList(newlist);
        enterpriseNC.setCount(enterpriseBriefVO.getCount());

        return ResultVO.success(enterpriseNC);
    }
}
