package com.agri.agribigdata.utils;

public class TextLengthUtils {
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
}
