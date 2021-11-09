package ion.kosa.TazanBack.VO;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class planCreateVO {
    private int planID;
    private int userID;
    private String region;
    private Date startDate;
    private Date endDate;
    private Date planDate;
    private String planTitle;
    private ArrayList planList;
}
