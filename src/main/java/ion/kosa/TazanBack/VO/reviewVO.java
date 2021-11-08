package ion.kosa.TazanBack.VO;

import lombok.Data;

import javax.persistence.Lob;
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
    @Lob
    private String reviewContent;
    private String reviewTitle;
    private String nickName;
}
