package com.agri.agribigdata.entity.vo;

import com.agri.agribigdata.entity.po.ArticlePO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO {
    private List<ArticlePO> articleList;
    private Integer count;
}
