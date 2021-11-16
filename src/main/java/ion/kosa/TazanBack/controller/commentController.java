package ion.kosa.TazanBack.controller;

import ion.kosa.TazanBack.Service.commentServiceImpl;
import ion.kosa.TazanBack.VO.commentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class commentController {

    private final commentServiceImpl commentService;

    @PostMapping("/comment/create")
    public void createComment(@RequestBody commentVO commentVO){
        commentService.createComment(commentVO);
    }

    @GetMapping("/comment/select/{reviewID}")
    public @ResponseBody List<commentVO> selectComment(@PathVariable int reviewID){
        return commentService.selectComment(reviewID);
    }
}
