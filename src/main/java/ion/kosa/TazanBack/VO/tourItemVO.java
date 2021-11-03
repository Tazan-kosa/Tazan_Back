package ion.kosa.TazanBack.VO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class tourItemVO {
    private int TourId;
    private String Address;
    private String TourRegion;
    private String Tag1,Tag2;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date EndDate;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date StartDate;

    private String Img;
    private float Latitude,Longitude;
    private int Height;
    private String Contact,Title,URL;
    private int Likes;
}
