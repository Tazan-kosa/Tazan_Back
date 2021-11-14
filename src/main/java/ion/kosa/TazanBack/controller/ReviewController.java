package ion.kosa.TazanBack.controller;


import ion.kosa.TazanBack.Service.reviewServiceImpl;
import ion.kosa.TazanBack.VO.reviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ReviewController {

    private final reviewServiceImpl reviewServiceImpl;


    @PostMapping(value = "/review/upload")
    public @ResponseBody
    int reviewUpload(@RequestBody reviewVO reviewVO) {
        return reviewServiceImpl.reviewUpload(reviewVO);
    }

    //list
    @GetMapping("/review/download")
    public ResponseEntity reviewDownload(int reviewID) {
        reviewServiceImpl.reviewDownload(reviewID);
        return null;
    }

    //키워드 검색
    @GetMapping("/review/{reviewid}")
    public @ResponseBody
    reviewVO reviewdetail(@PathVariable int reviewid) {
        return reviewServiceImpl.reviewDownload(reviewid);
    }

    @GetMapping(value = {"/review/reviewList", "/review/search"})
    public @ResponseBody
    List<reviewVO> reviewList() {
        return reviewServiceImpl.reviewList();
    }

    //키워드 검색
    @GetMapping("/review/search/{keyword}/{startdate}/{enddate}")
    public @ResponseBody
    List<reviewVO> search(@PathVariable String keyword, @PathVariable String startdate, @PathVariable String enddate) {
        List<reviewVO> keywordTourList;
        if (keyword.equals("noneKeyword")) {
            keywordTourList = reviewServiceImpl.selectKeyword("", startdate, enddate);
        } else {
            keywordTourList = reviewServiceImpl.selectKeyword(keyword, startdate, enddate);
        }

        return keywordTourList;
    }


    //Top 4 TourList
    @GetMapping("/review/recent")
    public @ResponseBody
    List<reviewVO> reviewRecent() {
        List<reviewVO> recentreview = reviewServiceImpl.reviewRecent();
        return recentreview;
    }

    // Delete Review
    @DeleteMapping("/reviewDelete/{reviewID}")
    public void reviewDelete(@PathVariable int reviewID) {
        reviewServiceImpl.reviewDelete(reviewID);
    }

    @PutMapping("/review/update")
    public void reviewUpdate(@RequestBody reviewVO reviewVO) {
        reviewServiceImpl.reviewUpdate(reviewVO);
    }

    @GetMapping("/review/myLiviewList/{userID}")
    public List<reviewVO> selectdate(@PathVariable int userID) {
        return reviewServiceImpl.myReviewList(userID);
    }

    @GetMapping("/reviwe/reviewWrite/{planID}")
    public reviewVO reviewWrite(@PathVariable int planID){
        return reviewServiceImpl.myReviewSelect(planID);
    }
}
