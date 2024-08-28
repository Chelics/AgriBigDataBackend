package com.agri.agribigdata.entity.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleQuery {
    private Integer prvc;
    private Integer type;
    private String title;
}
