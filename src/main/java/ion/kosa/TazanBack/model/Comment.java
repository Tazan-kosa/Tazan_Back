package ion.kosa.TazanBack.model;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private int CommentID;
    private int UserID;
    private int ReviewID;
    private Date CommentDate;
    private String CommentContent;
}
