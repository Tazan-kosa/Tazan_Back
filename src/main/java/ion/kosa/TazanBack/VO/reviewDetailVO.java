package ion.kosa.TazanBack.VO;

import lombok.Data;

import javax.persistence.Lob;
import java.util.Date;
import java.util.List;

@Data
public class reviewDetailVO {
    private reviewVO reviewVO;
    private planVO planVO;
}
