package ion.kosa.TazanBack.controller;


import ion.kosa.TazanBack.Service.planServiceImpl;
import ion.kosa.TazanBack.VO.planCreateVO;
import ion.kosa.TazanBack.VO.planVO;
import ion.kosa.TazanBack.model.Plan;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class planController {

    private final planServiceImpl planServiceImpl;


    @PostMapping("/api/user/plan/create")
    public int planCreate(@RequestBody planCreateVO planCreateVO){
        return planServiceImpl.planCreate(planCreateVO);

    }

    @GetMapping("/api/user/planDetail/{planID}")
    public planVO getPlan(@PathVariable int planID){

        return planServiceImpl.getPlan(planID);
    }

    @GetMapping("/api/user/plan/myPlan/{userID}")
    public @ResponseBody List<Plan> selectMyPlan(@PathVariable int userID){

        return planServiceImpl.selectMyPlan(userID);
    }

    @DeleteMapping("/api/user/planDelete/{planID}")
    public void deletePlan(@PathVariable int planID){

        planServiceImpl.deletePlan(planID);
    }

    @GetMapping("/api/user/plan/myPlanList")
    public @ResponseBody List<planVO> planList(){
        return planServiceImpl.planList();
    }

    @PutMapping("/api/user/plan/planUpdate")
    public void planUpdate(@RequestBody planCreateVO planCreateVO){
        planServiceImpl.planUpdate(planCreateVO);
    }

}
