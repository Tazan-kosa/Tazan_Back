package ion.kosa.TazanBack.VO;

import lombok.Data;

import java.util.Date;

@Data
public class commentAllVO {
    private int commentID;
    private int userID;
    private String nickName;
    private int reviewID;
    private String reviewTitle;
    private String commentDate;
    private String commentContent;
    private int reportCount;
}
