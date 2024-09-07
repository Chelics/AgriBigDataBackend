package com.agri.agribigdata.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BriefPrvcPO {
    private String prvc;
    private Integer marketNum;
    private String mainPz;
    private String lowPz;
    private String highPz;
}
