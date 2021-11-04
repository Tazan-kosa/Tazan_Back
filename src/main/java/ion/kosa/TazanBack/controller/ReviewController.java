package ion.kosa.TazanBack.controller;


import ion.kosa.TazanBack.Service.reviewServiceImpl;
import ion.kosa.TazanBack.Service.userServiceImpl;
import ion.kosa.TazanBack.VO.reviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ReviewController {

    private final reviewServiceImpl reviewServiceImpl;

    @PostMapping("/review/upload")
    public ResponseEntity reviewUpload(@RequestBody reviewVO reviewVO){
        reviewServiceImpl.reviewUpload(reviewVO);

        return null;
    }
    @GetMapping("/review/download")
    public ResponseEntity reviewDownload(int reviewID){
        reviewServiceImpl.reviewDownload(reviewID);
        return null;
    }
}
