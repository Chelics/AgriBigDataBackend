package com.agri.agribigdata.service;

import com.agri.agribigdata.entity.query.ArticleGuideQuery;
import com.agri.agribigdata.entity.query.ArticleNewsQuery;
import com.agri.agribigdata.entity.query.PzQuery;
import com.agri.agribigdata.entity.vo.ArticleGuideVO;
import com.agri.agribigdata.entity.vo.ArticleNewsVO;

import java.util.List;

public interface ArticleService {
    List<String> getPzForArticle(PzQuery pzQuery);

    List<ArticleGuideVO> getGuideArticle(ArticleGuideQuery articleGuideQuery);

    List<ArticleNewsVO> getNewsArticle(ArticleNewsQuery articleNewsQuery);
}
