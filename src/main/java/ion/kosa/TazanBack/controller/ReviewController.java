package ion.kosa.TazanBack.controller;


import ion.kosa.TazanBack.VO.reviewVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class ReviewController {

    @PostMapping("/review/upload")
    public ResponseEntity reviewUpload(@ModelAttribute reviewVO reviewVO){

        return null;
    }
    @GetMapping("/review/download")
    public ResponseEntity reviewDownload(@ModelAttribute reviewVO reviewVO){

        return null;
    }
}
