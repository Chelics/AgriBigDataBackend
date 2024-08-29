package com.agri.agribigdata.entity.query;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PersonalQuery {
    private String username;
    private String prvc;
    private List<String> pzList;
}
