package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.VO.planCreateVO;
import ion.kosa.TazanBack.VO.planVO;
import ion.kosa.TazanBack.VO.reviewVO;
import ion.kosa.TazanBack.model.Plan;
import ion.kosa.TazanBack.model.Review;

import java.util.List;

public interface planService {
    int planCreate(planCreateVO planCreateVO);
    planVO dataToVO(Plan plan);
    Plan voToData(planCreateVO planVO);
    planVO getPlan(int planID);
    List<Plan> selectMyPlan(int userID);
    List<planVO> planList();
    void deletePlan(int planID);
    void updateReviewFlag(int planID);
}
