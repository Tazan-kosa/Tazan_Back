package ion.kosa.TazanBack.VO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class reviewVO {
    private int reviewID;
    private int userID;
    private int planID;
    private String region;
    private Date startDate;
    private Date endDate;
    private Date reviewDate;
    private List<reviewContentVO> reviewContent;
    private String reviewTitle;
}
