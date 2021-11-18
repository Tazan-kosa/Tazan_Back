package ion.kosa.TazanBack.DAO;

import ion.kosa.TazanBack.VO.commentVO;
import ion.kosa.TazanBack.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface commentDAO {
    void createComment(Comment comment);
    List<Comment> selectComment(int ReviewID);
    void deleteComment(int commentID);
    void updateComment(commentVO commentVO);
}
