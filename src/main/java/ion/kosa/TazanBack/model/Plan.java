package ion.kosa.TazanBack.model;

import lombok.Data;

import java.util.Date;

@Data
public class Plan {
    private int planID;
    private int userID;
    private String region;
    private Date startDate;
    private Date endDate;
    private Date planDate;
    private String planTitle;
    private String planList;
    private String planSize;
}
