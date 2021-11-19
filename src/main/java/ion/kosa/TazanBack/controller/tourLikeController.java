package ion.kosa.TazanBack.controller;

import ion.kosa.TazanBack.Service.tourLikeServiceImpl;
import ion.kosa.TazanBack.Service.tourListServiceImpl;
import ion.kosa.TazanBack.VO.tourItemVO;
import ion.kosa.TazanBack.VO.tourLikeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class tourLikeController {
    @Autowired
    tourLikeServiceImpl service;


    @GetMapping("/tour/like/{userID}")
    public @ResponseBody
    List<tourLikeVO> tourLikeList(@PathVariable int userID){

        return service.tourLikeList(userID);
    }


    @DeleteMapping("/tour/deleteTourLike/{tourLikeID}")
    public void tourLikedelete(@PathVariable int tourLikeID) {
        service.tourLikedelete(tourLikeID);
    }


    @PostMapping("/tour/insertTourLike")
    public int tourLikeinsert(@RequestBody tourLikeVO tourLikeVO){
        return service.tourLikeinsert(tourLikeVO);
    }
}
