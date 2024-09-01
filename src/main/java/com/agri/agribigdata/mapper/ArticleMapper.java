package com.agri.agribigdata.mapper;

import com.agri.agribigdata.entity.query.ArticleGuideQuery;
import com.agri.agribigdata.entity.query.ArticleNewsQuery;
import com.agri.agribigdata.entity.vo.ArticleGuideVO;
import com.agri.agribigdata.entity.vo.ArticleNewsVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ArticleMapper {

    List<String> getPz(String name);

    List<ArticleGuideVO> getGuideArticle(ArticleGuideQuery articleGuideQuery);

    List<ArticleNewsVO> getNewsArticle(ArticleNewsQuery articleNewsQuery);
}
