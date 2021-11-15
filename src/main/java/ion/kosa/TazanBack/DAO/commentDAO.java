package ion.kosa.TazanBack.DAO;

import ion.kosa.TazanBack.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface commentDAO {
    void createComment(Comment comment);
    List<Comment> selectComment(int ReviewID);
}
