package com.agri.agribigdata.entity.vo;

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

}
