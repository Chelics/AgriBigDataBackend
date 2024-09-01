package com.agri.agribigdata.controller;

import com.agri.agribigdata.entity.query.ArticleGuideQuery;
import com.agri.agribigdata.entity.query.ArticleNewsQuery;
import com.agri.agribigdata.entity.query.PzQuery;
import com.agri.agribigdata.entity.vo.ResultVO;
import com.agri.agribigdata.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping("/article/pz")
    public ResultVO getPZForArticle(@RequestBody PzQuery pzQuery){
        return ResultVO.success(articleService.getPzForArticle(pzQuery));
    }

    @PostMapping("/article/guide")
    public ResultVO getGuideArticle(@RequestBody ArticleGuideQuery articleGuideQuery){
        return ResultVO.success(articleService.getGuideArticle(articleGuideQuery));
    }

    @PostMapping("/article/news")
    public ResultVO getNewsArticle(@RequestBody ArticleNewsQuery articleNewsQuery){
        return ResultVO.success(articleService.getNewsArticle(articleNewsQuery));
    }
}
