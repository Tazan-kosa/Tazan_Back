package ion.kosa.TazanBack.controller;

import ion.kosa.TazanBack.Service.tourListServiceImpl;
import ion.kosa.TazanBack.VO.tourItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class tourListController {
    @Autowired
    tourListServiceImpl service;

    //키워드 검색
    @GetMapping("/search/{keyword}/{startdate}/{enddate}")
    public @ResponseBody
    List<tourItemVO> search(@PathVariable String keyword, @PathVariable String startdate, @PathVariable String enddate){
        List<tourItemVO> keywordTourList;
        if(keyword.equals("noneKeyword")){
            keywordTourList = service.selectKeyword("",startdate,enddate);
        }
        else{
            keywordTourList = service.selectKeyword(keyword,startdate,enddate);
        }
        return keywordTourList;
    }

    @GetMapping("/search/{keyword}")
    public @ResponseBody
    List<tourItemVO> searchRegion(@PathVariable String keyword){

        return service.searchRegion(keyword);
    }

    //default data return
    @GetMapping(value = {"/tourList","/search"})
    public @ResponseBody
    List<tourItemVO> selectAllTourList(){
        List<tourItemVO> allTourList = service.selectAll();
        return allTourList;
    }

    //Top 4 TourList
    @GetMapping("/testdbTopFour")
    public @ResponseBody    List<tourItemVO> selectTopFour(){
        List<tourItemVO> fourTourList = service.selectTopFour();
        return fourTourList;
    }

    @DeleteMapping("/tour/deleteTour/{tourID}")
    public void tourDelete(@PathVariable int tourID) {
        service.tourDelete(tourID);
    }
}
