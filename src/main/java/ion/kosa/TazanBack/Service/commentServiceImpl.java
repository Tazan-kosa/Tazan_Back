package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.DAO.commentDAO;
import ion.kosa.TazanBack.VO.commentVO;
import ion.kosa.TazanBack.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class commentServiceImpl implements commentService{
    private final commentDAO commentDAO;
    @Override
    public commentVO dataToVO(Comment comment) {
        commentVO commentVO = new commentVO();
        commentVO.setCommentID(comment.getCommentID());
        commentVO.setUserID(comment.getUserID());
        commentVO.setReviewID(comment.getReviewID());
        commentVO.setCommentDate(comment.getCommentDate());
        commentVO.setCommentContent(comment.getCommentContent());
        commentVO.setNickName(comment.getNickName());
        return commentVO;
    }

    @Override
    public Comment VOToData(commentVO commentVO) {
        Comment comment = new Comment();
        comment.setUserID(commentVO.getUserID());
        comment.setReviewID(commentVO.getReviewID());
        comment.setCommentDate(commentVO.getCommentDate());
        comment.setCommentContent(commentVO.getCommentContent());
        return comment;
    }

    @Override
    public void createComment(commentVO commentVO) {
        commentDAO.createComment(VOToData(commentVO));
    }

    @Override
    public List<commentVO> selectComment(int reviewID) {
        List<Comment> comments = commentDAO.selectComment(reviewID);
        System.out.println(comments.get(0));
        List<commentVO> commentsVO = new ArrayList();
        for (Comment c : comments) {
            commentsVO.add(dataToVO(c));
        }
        System.out.println(commentsVO.get(0));
        return commentsVO;
    }
}
