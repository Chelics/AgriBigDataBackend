package com.agri.agribigdata.service.impl;

import com.agri.agribigdata.entity.bo.PriceBO;
import com.agri.agribigdata.entity.po.*;
import com.agri.agribigdata.entity.query.*;
import com.agri.agribigdata.entity.vo.*;
import com.agri.agribigdata.exception.CustomException;
import com.agri.agribigdata.mapper.PriceMapper;
import com.agri.agribigdata.service.PriceService;
import com.agri.agribigdata.utils.TextUtils;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    PriceMapper priceMapper;

    @Override
    public List<String> getMarketList(MarketPriceQuery marketPriceQuery) {
        return priceMapper.getMarketByPrvcAndName(marketPriceQuery);
    }

    @Override
    public List<String> getPzList(PzQuery pzQuery) {
        return priceMapper.getPz(pzQuery);
    }

    @Override
    public List<PriceTopRiseVO> getTopRise(PriceTopQuery priceTopQuery) {
        return priceMapper.getTopRise(priceTopQuery);
    }

    @Override
    public List<PriceTopFallVO> getTopFall(PriceTopQuery priceTopQuery) {
        return priceMapper.getTopFall(priceTopQuery);
    }

    @Override
    public PriceVO getPrice(PriceBO priceBO) {
        return new PriceVO(priceMapper.getPriceByPriceBO(priceBO), priceMapper.getPriceCount(priceBO));
    }

    @Override
    public List<IndexVO> getTwoIndex() {
        return IndexVO.transferIndexP2V(priceMapper.getTwoIndex());
    }

    @Override
    public List<IndexVO> getHbIndex() {
        return IndexVO.transferIndexP2V(priceMapper.getHbIndex());
    }

    @Override
    public PricePartialVO getSinglePzPartialPrice(PricePartialQuery pricePartialQuery) throws CustomException {
        PricePerPzWeekPO pricePerPzWeekPO = priceMapper.getPerPzWeekPartialHL(pricePartialQuery);
        List<PricePO> pricePOList = new ArrayList<>();
        if(pricePartialQuery.getIsPrediction()==true){
             pricePOList = priceMapper.getPriceByPz(pricePartialQuery);
        }else{
             pricePOList = priceMapper.getPriceByPzWithoutPrediction(pricePartialQuery);
        }

        if(pricePerPzWeekPO==null){
            throw new CustomException(404,String.format("品种%s在地区%s无今日价格信息",pricePartialQuery.getPz(),pricePartialQuery.getPrvc()),"所选品种在相应地区无综合价格信息");
        }
        if(pricePOList.size()==0){
            throw new CustomException(404,String.format("品种%s在地区%s无今日价格信息",pricePartialQuery.getPz(),pricePartialQuery.getPrvc()),"所选品种在相应地区无价格信息");
        }
        PricePartialVO pricePartialVO = PricePartialVO.transfer(pricePerPzWeekPO,pricePOList);
        return pricePartialVO;
    }

    @Override
    public PriceSingleMarketVO getSingleMarketPrice(PriceSingleMarketQuery priceSingleMarketQuery) throws CustomException {
        PricePerMarketTodayPO pricePerMarketTodayPO = priceMapper.getPerMarketTodayPrice(priceSingleMarketQuery);
        PricePerMarketWeekPO pricePerMarketWeekPO = priceMapper.getPerMarketWeekPrice(priceSingleMarketQuery);
        List<PricePO> pricePOList = new ArrayList<>();
        if(priceSingleMarketQuery.getIsPrediction()==true){
            pricePOList = priceMapper.getPriceByPzList(priceSingleMarketQuery);
        }else{
            pricePOList = priceMapper.getPriceByPzListWithoutPrediction(priceSingleMarketQuery);
        }

        if(pricePerMarketTodayPO==null){
            throw new CustomException(404,String.format("市场%s无今日价格信息",priceSingleMarketQuery.getMarket()),"所选市场无今日价格信息");
        }
        if(pricePerMarketWeekPO==null){
            throw new CustomException(404,String.format("市场%s无本周价格信息",priceSingleMarketQuery.getMarket()),"所选市场无本周价格信息");
        }
        if(pricePOList.size()==0){
            throw new CustomException(404,String.format("市场%s无品种%s价格信息",priceSingleMarketQuery.getMarket(),priceSingleMarketQuery.getPzList().toString()),"所选市场无品种价格信息");
        }
        return PriceSingleMarketVO.transfer(pricePerMarketTodayPO,pricePerMarketWeekPO,pricePOList);
    }

    @Override
    public PriceSinglePzVO getSinglePzPrice(PriceSinglePzQuery priceSinglePzQuery) throws CustomException {
        PricePerPzTodayPO pricePerPzTodayPO = priceMapper.getPerPzTodayPrice(priceSinglePzQuery);
        PricePerPzWeekPO pricePerPzWeekPO = priceMapper.getPerPzWeekPrice(priceSinglePzQuery);
        List<PricePO> pricePOList = new ArrayList<>();
        if(priceSinglePzQuery.getIsPrediction()==true){
            pricePOList = priceMapper.getPriceByMarketList(priceSinglePzQuery);
        }else{
            pricePOList = priceMapper.getPriceByMarketListWithoutPrediction(priceSinglePzQuery);
        }
        if(pricePerPzTodayPO==null){
            throw new CustomException(404,String.format("品种%s无今日价格信息",priceSinglePzQuery.getPz()),"所选品种无今日价格信息");
        }
        if(pricePerPzWeekPO==null){
            throw new CustomException(404,String.format("品种%s无本周价格信息",priceSinglePzQuery.getPz()),"所选品种无本周价格信息");
        }
        if(pricePOList.size()==0){
            throw new CustomException(404,String.format("品种%s无市场%s价格信息",priceSinglePzQuery.getPz(),priceSinglePzQuery.getMarketList().toString()),"所选品种无市场价格信息");
        }
        return PriceSinglePzVO.transfer(pricePerPzTodayPO, pricePerPzWeekPO, pricePOList);
    }

    @Override
    public String getPriceBrief(PriceBriefQuery priceBriefQuery) {
        if (StringUtils.isNotBlank(priceBriefQuery.getMarket()) && StringUtils.isNotBlank(priceBriefQuery.getPz())) {
            return TextUtils.processPriceBriefWithMarketAndPz(priceMapper.getBriefMarketPz(priceBriefQuery.getMarket(), priceBriefQuery.getPz()));
        } else if (StringUtils.isNotBlank(priceBriefQuery.getPrvc()) && StringUtils.isNotBlank(priceBriefQuery.getPz())) {
            return TextUtils.processPriceBriefWithPrvcAndPz(priceMapper.getBriefPrvcPz(priceBriefQuery.getPrvc(), priceBriefQuery.getPz()));
        } else if(StringUtils.isNotBlank(priceBriefQuery.getMarket())){
            return TextUtils.processPriceBriefWithMarket(priceMapper.getBriefMarket(priceBriefQuery.getMarket()));
        } else if (StringUtils.isNotBlank(priceBriefQuery.getPrvc())) {
            return TextUtils.processPriceBriefWithPrvc(priceMapper.getBriefPrvc(priceBriefQuery.getPrvc()));
        } else if(StringUtils.isNotBlank(priceBriefQuery.getPz())){
            return TextUtils.processPriceBriefWithPz(priceMapper.getBriefPz(priceBriefQuery.getPz()));
        }
        return null;
    }
}
