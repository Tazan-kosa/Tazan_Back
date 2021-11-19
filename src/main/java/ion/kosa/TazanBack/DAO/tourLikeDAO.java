package ion.kosa.TazanBack.DAO;

import ion.kosa.TazanBack.model.Plan;
import ion.kosa.TazanBack.model.TourLike;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface tourLikeDAO {
    List<TourLike> tourLikeList(int userID);
    void tourLikedelete(int tourLikeID);
    int tourLikeinsert(TourLike tourLike);
}
