package com.agri.agribigdata.config;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class VerifyConfig {
    private Integer verifyMinutes = 5;
    private String verifyDescription = "五分钟";

    public VerifyConfig verifyConfig(){
        return new VerifyConfig();
    }
}
