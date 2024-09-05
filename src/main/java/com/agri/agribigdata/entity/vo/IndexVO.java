package com.agri.agribigdata.entity.vo;

import com.agri.agribigdata.entity.po.IndexPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndexVO {
    private String pl;
    private Double index;
    private Double rise;
    private Double qoq;

    public static List<IndexVO> transferIndexP2V(List<IndexPO> indexPOList){
        List<IndexVO> indexVOList = new ArrayList<>();
        for(IndexPO indexPO:indexPOList){
            IndexVO indexVO = new IndexVO();
            indexVO.setPl(indexPO.getPl());
            indexVO.setIndex(indexPO.getIndexValue());
            indexVO.setQoq(indexPO.getQoq());
            indexVO.setRise(indexPO.getRise());
            indexVOList.add(indexVO);
        }
        return indexVOList;
    }
}
