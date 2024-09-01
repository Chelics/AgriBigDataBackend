package com.agri.agribigdata.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndexVO {
    private String pl;
    private Double index;
    private Double rise;
    private Double qoq;
}
