package ion.kosa.TazanBack.VO;

import lombok.Data;

import java.util.Date;

@Data
public class commentVO {
    private int commentID;
    private int userID;
    private String nickName;
    private int reviewID;
    private Date commentDate;
    private String commentContent;
}
