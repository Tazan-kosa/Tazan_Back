package ion.kosa.TazanBack.controller;

import ion.kosa.TazanBack.Service.commentServiceImpl;
import ion.kosa.TazanBack.VO.commentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class commentController {

    private final commentServiceImpl commentService;

    @PostMapping("/comment/create")
    public @ResponseBody commentVO createComment(@RequestBody commentVO commentVO){
        return commentService.createComment(commentVO);
    }

    @GetMapping("/comment/select/{reviewID}")
    public @ResponseBody List<commentVO> selectComment(@PathVariable int reviewID){
        return commentService.selectComment(reviewID);
    }

    @DeleteMapping("/comment/delete/{commentID}")
    public void deleteComment(@PathVariable int commentID){
        commentService.deleteComment(commentID);
    }

    @PutMapping("/comment/update")
    public void updateComment(@RequestBody commentVO commentVO){
        commentService.updateComment(commentVO);
    }
}
