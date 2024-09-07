package com.agri.agribigdata.utils;

import com.agri.agribigdata.entity.po.*;
import io.micrometer.common.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TextUtils {
    public static String processArticleGuideTitle(String title) {
        int maxLength = 12;
        if (title.length() > maxLength) {
            return title.substring(0, maxLength) + "...";
        }
        return title;
    }

    public static String processArticleGuideBrief(String brief) {
        int maxLength = 100;
        if (brief.length() > maxLength) {
            return brief.substring(0, maxLength) + "...";
        }
        return brief;
    }

    private static String getYesterday(){
        LocalDate date = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日");
        return date.format(formatter);
    }

    public static String processPriceBriefWithMarketAndPz(BriefMarketPzPO briefMarketPzPO){
        StringBuilder brief = new StringBuilder();

        brief.append("昨日(").append(getYesterday()).append("), 【")
                .append(briefMarketPzPO.getMarket()).append("】的【")
                .append(briefMarketPzPO.getPz()).append("】平均价格为")
                .append(briefMarketPzPO.getAverage()).append("元, ");

        if (briefMarketPzPO.getHighest() != briefMarketPzPO.getLowest()) {
            brief.append("价格范围为").append(briefMarketPzPO.getLowest())
                    .append("~").append(briefMarketPzPO.getHighest()).append("元。");
        } else {
            brief.append("价格稳定在").append(briefMarketPzPO.getAverage()).append("左右。");
        }

        brief.append("与前天相比, ").append(briefMarketPzPO.getPz())
                .append("的平均价格");

        if (briefMarketPzPO.getVariation() > 0) {
            brief.append("上涨了").append(briefMarketPzPO.getVariation()).append("元。");
        } else if (briefMarketPzPO.getVariation() < 0) {
            brief.append("下跌了").append(briefMarketPzPO.getVariation()).append("元。");
        } else {
            brief.append("保持平稳。");
        }

        brief.append("预计今日的价格为").append(briefMarketPzPO.getPredictTd()).append("元, ")
                .append("明日的价格可能会上涨至").append(briefMarketPzPO.getPredictTm()).append("元。");

        return brief.toString();
    }

    public static String processPriceBriefWithPrvcAndPz(BriefPrvcPzPO briefPrvcPzPO){
        StringBuilder brief = new StringBuilder();

        brief.append("昨日(").append(getYesterday()).append("), ")
                .append(briefPrvcPzPO.getPrvc()).append("的【")
                .append(briefPrvcPzPO.getPz()).append("】平均价格为")
                .append(briefPrvcPzPO.getAverage()).append("元, ");

        if (briefPrvcPzPO.getHighest() != briefPrvcPzPO.getLowest()) {
            brief.append("价格范围为").append(briefPrvcPzPO.getLowest())
                    .append("~").append(briefPrvcPzPO.getHighest()).append("元。");
        } else {
            brief.append("价格稳定在").append(briefPrvcPzPO.getAverage()).append("左右。");
        }

        brief.append("与前天相比, ").append(briefPrvcPzPO.getPz())
                .append("的平均价格");

        if (briefPrvcPzPO.getVariation() > 0) {
            brief.append("上涨了").append(briefPrvcPzPO.getVariation()).append("元。");
        } else if (briefPrvcPzPO.getVariation() < 0) {
            brief.append("下跌了").append(briefPrvcPzPO.getVariation()).append("元。");
        } else {
            brief.append("保持平稳。");
        }

        brief.append("预计今日的价格为").append(briefPrvcPzPO.getPredictTd()).append("元, ")
                .append("明日的价格可能会上涨至").append(briefPrvcPzPO.getPredictTm()).append("元。");

        return brief.toString();
    }


    public static String processPriceBriefWithPrvc(BriefPrvcPO briefPrvcPO){
        StringBuilder brief = new StringBuilder();
        brief.append(briefPrvcPO.getPrvc()).append("中有").append(briefPrvcPO.getMarketNum()).append("个市场。");
        if (StringUtils.isNotBlank(briefPrvcPO.getMainPz())) {
            brief.append("这些市场的主营品种有").append(briefPrvcPO.getMainPz()).append("。");
        }
        if (StringUtils.isNotBlank(briefPrvcPO.getHighPz())) {
            brief.append("均价高于全国的品种有").append(briefPrvcPO.getHighPz()).append("。");
        }
        if (StringUtils.isNotBlank(briefPrvcPO.getLowPz())) {
            brief.append("均价低于全国的品种有").append(briefPrvcPO.getLowPz()).append("。");
        }
        return brief.toString();
    }

    public static String processPriceBriefWithMarket(BriefMarketPO briefMarketPO){
        StringBuilder brief = new StringBuilder();
        brief.append(briefMarketPO.getMarket())
                .append("有")
                .append(briefMarketPO.getPzNum())
                .append("种品种。");
        if (StringUtils.isNotBlank(briefMarketPO.getHighPz())) {
            brief.append("均价高于全国的有")
                    .append(briefMarketPO.getHighPz())
                    .append("。");
        }
        if (StringUtils.isNotBlank(briefMarketPO.getLowPz())) {
            brief.append("均价低于全国的有")
                    .append(briefMarketPO.getLowPz())
                    .append("。");
        }
        return brief.toString();
    }

    public static String processPriceBriefWithPz(BriefPzPO briefPzPO){
        StringBuilder brief = new StringBuilder();
        brief.append(briefPzPO.getPz())
                .append("的全国均价为")
                .append(briefPzPO.getAverage())
                .append("。");
        if (StringUtils.isNotBlank(briefPzPO.getHighPrvc())) {
            brief.append("均价高于全国均价的省份有")
                    .append(briefPzPO.getHighPrvc())
                    .append("。");
        }
        if (StringUtils.isNotBlank(briefPzPO.getLowPrvc())) {
            brief.append("均价低于全国均价的省份有")
                    .append(briefPzPO.getLowPrvc())
                    .append("。");
        }
        return brief.toString();
    }
}
