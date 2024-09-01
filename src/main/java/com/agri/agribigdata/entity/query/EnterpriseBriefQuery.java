package com.agri.agribigdata.entity.query;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseBriefQuery {
    private String prvc = null;
    private String pz = null;
    private String supplyType = null;
    private Integer pageSize = 10;
    private Integer pageNum = 1;
}
