package ion.kosa.TazanBack.controller;

import ion.kosa.TazanBack.Service.commentServiceImpl;
import ion.kosa.TazanBack.VO.commentAllVO;
import ion.kosa.TazanBack.VO.commentVO;
import ion.kosa.TazanBack.model.dto.UserRoleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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

    @GetMapping("/admin/comment/selectAll")
    public @ResponseBody
    List<commentAllVO> selectAllComment(@RequestBody UserRoleDTO userRole){
        String role = userRole.getUserRole();
        if(role.equals("ROLE_ADMIN")) return commentService.selectAllComment();
        return null;
    }
}
