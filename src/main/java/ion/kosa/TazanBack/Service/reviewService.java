package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.VO.reviewVO;
import ion.kosa.TazanBack.model.Review;

public interface reviewService {
    void reviewUpload(reviewVO reviewVO);
    reviewVO reviewDownload(int reviewID);
    reviewVO dataToVO(Review review);
    Review voToData(reviewVO reviewVO);
}
