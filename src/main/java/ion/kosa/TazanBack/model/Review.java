package ion.kosa.TazanBack.model;

import lombok.Data;

import java.util.Date;

@Data
public class Review {

    private int reviewID;
    private int userID;
    private int planID;
    private String region;
    private Date startDate;
    private Date endDate;
    private Date reviewDate;
    private String reviewContent;
    private String reviewTitle;
}
