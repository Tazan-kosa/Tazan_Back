package ion.kosa.TazanBack.DAO;

import ion.kosa.TazanBack.model.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface reviewDAO {
    Review reviewDownload(int reviewID);
    void reviewUpload(Review review);
    List<Review> reviewList();
    List<Review> reviewmanageList();
    List<Review> selectKeyword(String keyword,String startdate,String enddate);
    List<Review> reviewRecent();
    void reviewDelete(int reviewID);
    void reviewUpdate(Review review);
    List<Review> myReviewList(int userID);
    Review myReviewSelect(int planID);
}
