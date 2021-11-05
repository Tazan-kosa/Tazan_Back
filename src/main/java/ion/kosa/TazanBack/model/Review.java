package ion.kosa.TazanBack.model;

import lombok.Data;

import javax.persistence.Lob;
import java.util.Date;

@Data
public class Review {

    private int ReviewID;
    private int UserID;
    private int PlanID;
    private String Region;
    private Date StartDate;
    private Date EndDate;
    private Date ReviewDate;
    @Lob
    private String ReviewContent;
    private String ReviewTitle;
}
