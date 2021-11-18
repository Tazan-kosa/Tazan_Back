package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.DAO.commentDAO;
import ion.kosa.TazanBack.VO.commentAllVO;
import ion.kosa.TazanBack.VO.commentReportVO;
import ion.kosa.TazanBack.VO.commentVO;
import ion.kosa.TazanBack.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(comment.getCommentDate());
        commentVO.setCommentDate(date);
        commentVO.setCommentContent(comment.getCommentContent());
        commentVO.setNickName(comment.getNickName());
        return commentVO;
    }

    @Override
    public Comment VOToData(commentVO commentVO) {
        Comment comment = new Comment();
        comment.setUserID(commentVO.getUserID());
        comment.setReviewID(commentVO.getReviewID());
        Date nowDate = new Date();
        comment.setCommentDate(nowDate);
        comment.setCommentContent(commentVO.getCommentContent());
        return comment;
    }

    @Override
    public commentVO createComment(commentVO commentVO) {
        Comment comment = VOToData(commentVO);
        commentDAO.createComment(comment);
        return dataToVO(comment);
    }

    @Override
    public List<commentVO> selectComment(int reviewID) {
        List<Comment> comments = commentDAO.selectComment(reviewID);
        List<commentVO> commentsVO = new ArrayList();
        for (Comment c : comments) {
            commentsVO.add(dataToVO(c));
        }
        return commentsVO;
    }

    @Override
    public void deleteComment(int commentID) {
        commentDAO.deleteComment(commentID);
    }

    @Override
    public void updateComment(commentVO commentVO) {
        commentDAO.updateComment(commentVO);
    }

    @Override
    public List<commentAllVO> selectAllComment() {
        return commentDAO.selectAllComment();
    }

    @Override
    public void updateReportCount(int commentID) {
        commentDAO.updateReportCount(commentID);
    }

    @Override
    public void insertReportFlag(commentReportVO commentReportVO) {
        commentDAO.insertReportFlag(commentReportVO);
    }
}
