package com.agri.agribigdata.entity.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceBriefQuery {
    private String prvc;
    private String market;
    private String pz;
}
