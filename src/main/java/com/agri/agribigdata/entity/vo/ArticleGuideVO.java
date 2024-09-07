package com.agri.agribigdata.entity.vo;

import com.agri.agribigdata.entity.bo.ArticleGuideBO;
import com.agri.agribigdata.utils.TextUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleGuideVO {
    private String title;
    private String link;
    private String releaseDate;
    private String brief;
    private String pz;

    public static ArticleGuideVO transferArticleGuideB2V(ArticleGuideBO articleGuideBO) throws Exception{
        ArticleGuideVO articleGuideVO = new ArticleGuideVO();
        articleGuideVO.setPz(articleGuideBO.getPz());
        articleGuideVO.setLink(articleGuideBO.getLink());
        articleGuideVO.setReleaseDate(articleGuideBO.getReleaseDate());
        articleGuideVO.setTitle(TextUtils.processArticleGuideTitle(articleGuideBO.getTitle()));
        articleGuideVO.setBrief(TextUtils.processArticleGuideBrief(articleGuideBO.getBrief()));
        return articleGuideVO;
    }
}
