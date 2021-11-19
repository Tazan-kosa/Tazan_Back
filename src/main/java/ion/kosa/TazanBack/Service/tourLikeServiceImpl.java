package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.DAO.tourLikeDAO;
import ion.kosa.TazanBack.VO.tourLikeVO;
import ion.kosa.TazanBack.model.TourLike;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class tourLikeServiceImpl implements tourLikeService {

    private final tourLikeDAO tourLikeDAO;

    @Override
    public List<tourLikeVO> tourLikeList(int userID) {
        List<TourLike> tourLike = tourLikeDAO.tourLikeList(userID);
        List<tourLikeVO> likes = new ArrayList<>();
        Iterator iterator = tourLike.iterator();
        while (iterator.hasNext()) {
            TourLike tour = (TourLike) iterator.next();
            tourLikeVO vo = new tourLikeVO();
            vo.setTourLikeID(tour.getTourLikeID());
            vo.setTourID(tour.getTourID());
            vo.setUserID(tour.getUserID());
            likes.add(vo);
        }
        return likes;
    }

    @Override
    public void tourLikedelete(int tourLikeID) {
        tourLikeDAO.tourLikedelete(tourLikeID);
    }

    @Override
    public int tourLikeinsert(tourLikeVO tourLikeVO) {
        TourLike tour = new TourLike();
        tour.setTourID(tourLikeVO.getTourID());
        tour.setUserID(tourLikeVO.getUserID());
        tourLikeDAO.tourLikeinsert(tour);
        return tour.getTourLikeID();
    }
}
