package ion.kosa.TazanBack.DAO;

import ion.kosa.TazanBack.VO.reviewVO;
import ion.kosa.TazanBack.model.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface reviewDAO {
    Review reviewDownload(int reviewID);
    void reviewUpload(Review review);
    List<Review> reviewList();
}
