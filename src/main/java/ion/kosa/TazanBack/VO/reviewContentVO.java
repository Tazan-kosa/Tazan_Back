package ion.kosa.TazanBack.VO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class reviewContentVO {
    private String reviewContent;
    private MultipartFile reviewImage;
}
