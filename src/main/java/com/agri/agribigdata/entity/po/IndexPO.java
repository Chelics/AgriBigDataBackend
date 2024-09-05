package com.agri.agribigdata.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndexPO {
    private String pl;
    private Double indexValue;
    private Double rise;
    private Double qoq;
}
