package com.agri.agribigdata.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceMultiBO {
    private String releaseTime;
    private Double average;
    private String type;
    
    public PriceMultiBO(String releaseTime, Double average) {
        this.releaseTime = releaseTime;
        this.average = average;
        this.type = determineType(releaseTime);
    }

    private String determineType(String releaseTime) {
        LocalDate currentDate = LocalDate.now();
        LocalDate releaseDate = LocalDate.parse(releaseTime, DateTimeFormatter.ISO_DATE);
        if (releaseDate.isEqual(currentDate) || releaseDate.isAfter(currentDate)) {
            return "dashed";
        } else {
            return "";
        }
    }

}
