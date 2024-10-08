package com.agri.agribigdata.entity.query;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleGuideQuery {
    private String pz = null;
    private String title = null;
    private String startDate = null;
    private String endDate = null;
}
