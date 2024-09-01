package com.agri.agribigdata.entity.query;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleGuideQuery {
    private String pz;
    private String title;
    private String startDate;
    private String endDate;
}
