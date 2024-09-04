package com.agri.agribigdata.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleGuideBO {
    private String title;
    private String link;
    private String releaseDate;
    private String brief;
    private String pz;

}
