package com.agri.agribigdata.service.impl;

import com.agri.agribigdata.entity.query.ArticleGuideQuery;
import com.agri.agribigdata.entity.query.ArticleNewsQuery;
import com.agri.agribigdata.entity.query.ArticlePzQuery;
import com.agri.agribigdata.entity.vo.ArticleGuideVO;
import com.agri.agribigdata.entity.vo.ArticleNewsVO;
import com.agri.agribigdata.mapper.ArticleMapper;
import com.agri.agribigdata.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<String> getPzForArticle(ArticlePzQuery articlePzQuery) {
        return articleMapper.getPz(articlePzQuery.getName());
    }

    @Override
    public List<ArticleGuideVO> getGuideArticle(ArticleGuideQuery articleGuideQuery) {
        return articleMapper.getGuideArticle(articleGuideQuery);
    }

    @Override
    public List<ArticleNewsVO> getNewsArticle(ArticleNewsQuery articleNewsQuery) {
        return articleMapper.getNewsArticle(articleNewsQuery);
    }
}
