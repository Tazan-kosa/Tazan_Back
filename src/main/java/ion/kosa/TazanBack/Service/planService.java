package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.VO.planVO;
import ion.kosa.TazanBack.VO.reviewVO;
import ion.kosa.TazanBack.model.Plan;
import ion.kosa.TazanBack.model.Review;

import java.util.List;

public interface planService {
    void planCreate(planVO planVO);
    planVO dataToVO(Plan plan);
    Plan voToData(planVO planVO);
    planVO getPlan(int planID);
}
