package ion.kosa.TazanBack.controller;


import ion.kosa.TazanBack.Service.planServiceImpl;
import ion.kosa.TazanBack.Service.reviewServiceImpl;
import ion.kosa.TazanBack.VO.reviewDetailVO;
import ion.kosa.TazanBack.VO.reviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ReviewController {

    private final reviewServiceImpl reviewServiceImpl;
    private final planServiceImpl planServiceImpl;


    @PostMapping(value = "/api/user/review/upload")
    public @ResponseBody
    int reviewUpload(@RequestBody reviewVO reviewVO) {
        return reviewServiceImpl.reviewUpload(reviewVO);
    }

    //키워드 검색
    @GetMapping("/review/{reviewid}")
    public @ResponseBody
    reviewDetailVO reviewdetail(@PathVariable int reviewid) {
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
    @DeleteMapping("/api/user/reviewDelete/{reviewID}/{planID}")
    public void reviewDelete(@PathVariable int reviewID, @PathVariable int planID) {
        planServiceImpl.deleteReviewFlag(planID);
        reviewServiceImpl.reviewDelete(reviewID);
    }

    @PutMapping("/api/user/review/update")
    public void reviewUpdate(@RequestBody reviewVO reviewVO) {
        reviewServiceImpl.reviewUpdate(reviewVO);
    }

    @GetMapping("/api/user/review/myLiviewList/{userID}")
    public List<reviewVO> selectdate(@PathVariable int userID) {
        return reviewServiceImpl.myReviewList(userID);
    }

    @GetMapping("/api/admin/review/reviewmanageList")
    public @ResponseBody
    List<reviewVO> reviewmanageList() {
        return reviewServiceImpl.reviewmanageList();
    }

    @GetMapping("api/user/review/reviewWrite/{planID}")
    public reviewVO reviewWrite(@PathVariable int planID){
        return reviewServiceImpl.myReviewSelect(planID);
    }
}
