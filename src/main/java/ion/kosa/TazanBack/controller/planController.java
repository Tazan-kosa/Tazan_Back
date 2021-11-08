package ion.kosa.TazanBack.controller;


import ion.kosa.TazanBack.Service.planServiceImpl;
import ion.kosa.TazanBack.Service.reviewServiceImpl;
import ion.kosa.TazanBack.VO.planVO;
import ion.kosa.TazanBack.VO.reviewVO;
import ion.kosa.TazanBack.model.Plan;
import ion.kosa.TazanBack.model.Review;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class planController {

    private final planServiceImpl planServiceImpl;


    @PostMapping("/plan/create")
    public void planCreate(@RequestBody planVO planVO){
        planServiceImpl.planCreate(planVO);

    }

    @GetMapping("/plan/getPlan/{planID}")
    public planVO getPlan(@PathVariable int planID){

        return planServiceImpl.getPlan(planID);
    }

    @GetMapping("/plan/myPlan/{userID}")
    public @ResponseBody List<Plan> selectMyPlan(@PathVariable int userID){

        return planServiceImpl.selectMyPlan(userID);
    }


}
