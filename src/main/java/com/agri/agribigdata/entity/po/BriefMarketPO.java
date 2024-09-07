package com.agri.agribigdata.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BriefMarketPO {
    private String market;
    private Integer pzNum;
    private String lowPz;
    private String highPz;
}
