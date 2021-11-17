package ion.kosa.TazanBack.DAO;

import ion.kosa.TazanBack.VO.planVO;
import ion.kosa.TazanBack.model.Plan;
import ion.kosa.TazanBack.model.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface planDAO {
    int planCreate(Plan plan);
    Plan searchTourPlan(int planID);
    List<Plan> selectMyPlan(int userID);
    void deletePlan(int planID);
    List<Plan> planList();
    void updateReviewFlag(int planID);
    void deleteReviewFlag(int planID);
    void planUpdate(Plan plan);
}
