package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.VO.reviewVO;
import ion.kosa.TazanBack.VO.tourItemVO;
import ion.kosa.TazanBack.model.Review;

import java.util.List;

public interface reviewService {
    int reviewUpload(reviewVO reviewVO);
    reviewVO reviewDownload(int reviewID);
    reviewVO dataToVO(Review review);
    Review voToData(reviewVO reviewVO);
    List<reviewVO> reviewList();
    List<reviewVO> selectKeyword(String keyword);
    List<reviewVO> selectDate(String startdate,String enddate);
    List<reviewVO> reviewRecent();
    List<reviewVO> dataListToVOList(List<Review> review);
    void reviewDelete(int reviewID);
    void reviewUpdate(reviewVO reviewVO);
}
