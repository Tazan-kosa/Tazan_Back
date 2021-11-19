package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.VO.tourItemVO;
import ion.kosa.TazanBack.VO.tourLikeVO;
import ion.kosa.TazanBack.model.TourLike;

import java.util.List;

public interface tourLikeService {
    List<tourLikeVO> tourLikeList(int userID);
    void tourLikedelete(int tourLikeID);
    int tourLikeinsert(tourLikeVO tourLikeVO);
}
