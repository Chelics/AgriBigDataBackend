package com.agri.agribigdata.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticlePO {
    private Integer id;
    private String title;
    private String content;
    private String url;
    private Integer type;
    private Date date;
}
