package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.VO.planCreateVO;
import ion.kosa.TazanBack.VO.planVO;
import ion.kosa.TazanBack.DAO.planDAO;
import ion.kosa.TazanBack.VO.tourItemVO;
import ion.kosa.TazanBack.model.Plan;
import ion.kosa.TazanBack.model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class planServiceImpl implements planService {

    private final planDAO planDAO;

    @Autowired
    tourListServiceImpl service;

    @Override
    public int planCreate(planCreateVO planCreateVO) {

        Plan plan = voToData(planCreateVO);
        planDAO.planCreate(plan);
        return plan.getPlanID();
    }



    @Override
    public Plan voToData(planCreateVO planVO) {
        Plan plan = new Plan();

        plan.setEndDate(planVO.getEndDate());
        plan.setStartDate(planVO.getStartDate());
        plan.setPlanDate(new Date());
        plan.setUserID(planVO.getUserID());
        plan.setPlanTitle(planVO.getPlanTitle());
        plan.setRegion(planVO.getRegion());
        //planList 로직 처리
        String no = "";
        String noSize = "";
        Iterator iterator = planVO.getPlanList().iterator();
        while(iterator.hasNext()){
            ArrayList arr = (ArrayList) iterator.next();
            Iterator iterator1 = arr.iterator();
            while(iterator1.hasNext()) {
                String str = Integer.toString((int)iterator1.next());
                noSize+=str.length();
                no += str;

            }
            noSize+="#";

        }

        plan.setPlanList(no);
        plan.setPlanSize(noSize);
        return plan;
    }

    @Override
    public planVO getPlan(int planID) {
        return dataToVO(planDAO.searchTourPlan(planID));
    }

    @Override
    public List<Plan> selectMyPlan(int userID) {
        return planDAO.selectMyPlan(userID);
    }

    @Override
    public void deletePlan(int planID) {
        planDAO.deletePlan(planID);
    }

    @Override
    public planVO dataToVO(Plan plan) {
        planVO vo = new planVO();
        vo.setPlanID(plan.getPlanID());
        vo.setUserID(plan.getUserID());
        vo.setRegion(plan.getRegion());
        vo.setStartDate(plan.getStartDate());
        vo.setEndDate(plan.getEndDate());
        vo.setPlanDate(plan.getPlanDate());
        vo.setPlanTitle(plan.getPlanTitle());
        String no=plan.getPlanList();
        String noSize=plan.getPlanSize();

        ArrayList array = new ArrayList();
        ArrayList subarray = new ArrayList();
        for(int i=0;i<noSize.length();i++){

            //숫자(사이즈)인 경우
            if(!noSize.substring(i,i+1).equals("#")) {
                //사이즈 만큼 숫자 분리해냄
                String temp = no.substring(0, Integer.parseInt(noSize.substring(i, i + 1)));
                tourItemVO tourItemvo = service.selectTourID(Integer.parseInt(temp));
                subarray.add(tourItemvo);

                no=no.substring(Integer.parseInt(noSize.substring(i, i + 1)));
            }
            else{
                array.add(subarray);
                subarray = new ArrayList();
            }
        }
        vo.setPlanList(array);

        return vo;
    }
}
