package ion.kosa.TazanBack.VO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class tourItemVO {
    private int tourId;
    private String address;
    private String tourRegion;
    private String tag1,tag2;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date endDate;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date startDate;

    private String img;
    private float latitude,longitude;
    private int height;
    private String contact,title,url;
    private int likes;
}
