package ion.kosa.TazanBack.VO;

import lombok.Data;

@Data
public class commentVO {
    private int commentID;
    private int userID;
    private String nickName;
    private int reviewID;
    private String commentDate;
    private String commentContent;
}
