package com.agri.agribigdata.entity.vo;

import com.agri.agribigdata.entity.bo.UserBO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalVO {
    private String prvc;
    private List<String> pzList;

    public static PersonalVO transferB2V(UserBO userBO){
        PersonalVO personalVO = new PersonalVO();
        personalVO.setPrvc(userBO.getPrvc());
        personalVO.setPzList(userBO.getInterestedPzList());
        return personalVO;
    }
}
