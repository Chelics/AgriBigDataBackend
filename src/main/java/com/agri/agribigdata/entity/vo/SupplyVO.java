package com.agri.agribigdata.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplyVO {
    private String pz;
    private Double seedArea;
    private Double harvestedArea;
    private Double yield;
    private Double yieldRise;
    private Double yieldPerUnit;
    private Double imports;
    private Double exports;
    private Double portChange;
    private Double consumption;
    private Double consumptionRise;
    private Double balance;
    private Double balanceChange;

}
