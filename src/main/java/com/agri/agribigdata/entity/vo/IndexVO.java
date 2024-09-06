package com.agri.agribigdata.entity.vo;

import com.agri.agribigdata.entity.po.IndexPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndexVO {
    private String pl;
    private Double index;
    private Double rise;
    private Double rise3;
    private Double rise5;
    private Double qoq;

    public static List<IndexVO> transferIndexP2V(List<IndexPO> indexPOList){
        List<IndexVO> indexVOList = new ArrayList<>();
        for(IndexPO indexPO:indexPOList){
            IndexVO indexVO = new IndexVO();
            BeanUtils.copyProperties(indexPO,indexVO);
            indexVO.setIndex(indexPO.getIndexValue());
            indexVOList.add(indexVO);
        }
        return indexVOList;
    }
}
