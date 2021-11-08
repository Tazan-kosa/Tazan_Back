package ion.kosa.TazanBack.VO;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class planVO {
    private int planID;
    private int userID;
    private String region;
    private Date startDate;
    private Date endDate;
    private Date planDate;
    private String planTitle;
    private ArrayList planList;
}
