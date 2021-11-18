package ion.kosa.TazanBack.VO;

import lombok.Data;

import java.util.Date;

@Data
public class commentReportVO {
    private int commentID;
    private int userID;
    private Date reportDate;
}
