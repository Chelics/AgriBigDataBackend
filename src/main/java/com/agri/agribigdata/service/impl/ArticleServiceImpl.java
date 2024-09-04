package com.agri.agribigdata.service.impl;

import com.agri.agribigdata.entity.bo.ArticleGuideBO;
import com.agri.agribigdata.entity.query.ArticleGuideQuery;
import com.agri.agribigdata.entity.query.ArticleNewsQuery;
import com.agri.agribigdata.entity.query.PzQuery;
import com.agri.agribigdata.entity.vo.ArticleGuideVO;
import com.agri.agribigdata.entity.vo.ArticleNewsVO;
import com.agri.agribigdata.mapper.ArticleMapper;
import com.agri.agribigdata.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<String> getPzForArticle(PzQuery pzQuery) {
        return articleMapper.getPz(pzQuery.getName());
    }

    @Override
    public List<ArticleGuideVO> getGuideArticle(ArticleGuideQuery articleGuideQuery) throws Exception {
        List<ArticleGuideBO> articleGuideBOS = articleMapper.getGuideArticle(articleGuideQuery);
        List<ArticleGuideVO> articleGuideVOS = new ArrayList<>();
        for (ArticleGuideBO article : articleGuideBOS) {
            articleGuideVOS.add(ArticleGuideVO.transferArticleGuideB2V(article));
        }
        return articleGuideVOS;
    }

    @Override
    public List<ArticleNewsVO> getNewsArticle(ArticleNewsQuery articleNewsQuery) {
        return articleMapper.getNewsArticle(articleNewsQuery);
    }
}
