package ion.kosa.TazanBack.DAO;

import ion.kosa.TazanBack.VO.reviewVO;
import ion.kosa.TazanBack.model.Review;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface reviewDAO {
    Review reviewDownload(int reviewID);
    void reviewUpload(reviewVO reviewVO);
}
