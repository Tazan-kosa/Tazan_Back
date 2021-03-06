package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.VO.commentAllVO;
import ion.kosa.TazanBack.VO.commentReportVO;
import ion.kosa.TazanBack.VO.commentVO;
import ion.kosa.TazanBack.model.Comment;

import java.util.List;

public interface commentService {
    commentVO dataToVO(Comment comment);
    Comment VOToData(commentVO commentVo);
    commentVO createComment(commentVO commentVO);
    List<commentVO> selectComment(int ReviewID);
    void deleteComment(int commentID);
    void updateComment(commentVO commentVO);
    List<commentAllVO> selectAllComment();
    void updateReportCount(int commentID);
    void insertReportFlag(commentReportVO commentReportVO);
}
