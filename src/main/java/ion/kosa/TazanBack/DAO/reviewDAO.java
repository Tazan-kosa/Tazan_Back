package ion.kosa.TazanBack.DAO;

import ion.kosa.TazanBack.VO.reviewVO;
import ion.kosa.TazanBack.VO.tourItemVO;
import ion.kosa.TazanBack.model.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface reviewDAO {
    Review reviewDownload(int reviewID);
    int reviewUpload(Review review);
    List<Review> reviewList();
    List<reviewVO> selectKeyword(String keyword);
    List<reviewVO> selectDate(String startdate, String enddate);
    List<reviewVO> reviewRecent();
    void reviewDelete(int reviewID);
    void reviewUpdate(Review review);
}
