package ion.kosa.TazanBack.controller;


import ion.kosa.TazanBack.Service.reviewServiceImpl;
import ion.kosa.TazanBack.Service.userServiceImpl;
import ion.kosa.TazanBack.VO.reviewVO;
import ion.kosa.TazanBack.VO.tourItemVO;
import ion.kosa.TazanBack.model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ReviewController {

    private final reviewServiceImpl reviewServiceImpl;


    @PostMapping(value="/review/upload")
    public @ResponseBody int reviewUpload(@RequestBody reviewVO reviewVO){
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
    reviewVO reviewdetail(@PathVariable int reviewid){
        return reviewServiceImpl.reviewDownload(reviewid);
    }

    @GetMapping(value = {"/review/reviewList","/review/search"})
    public @ResponseBody List<Review> reviewList() {
        return reviewServiceImpl.reviewList();
    }

    //날짜기반 검색
    @GetMapping("/review/selectdate/{startdate}/{enddate}")
    public List<reviewVO> selectdate(@PathVariable String startdate, @PathVariable String enddate){
        List<reviewVO> selectdate = reviewServiceImpl.selectDate(startdate,enddate);
        return selectdate;
    }

    //키워드 검색
    @GetMapping("/review/search/{keyword}")
    public @ResponseBody
    List<reviewVO> search(@PathVariable String keyword){
        List<reviewVO> keywordTourList = reviewServiceImpl.selectKeyword(keyword);
        return keywordTourList;
    }


    //Top 4 TourList
    @GetMapping("/review/recent")
    public @ResponseBody List<reviewVO> reviewRecent(){
        List<reviewVO> recentreview = reviewServiceImpl.reviewRecent();
        return recentreview;
    }

    // Delete Review
    @DeleteMapping("/reviewDelete/{reviewID}")
    public void reviewDelete(@PathVariable int reviewID){
        reviewServiceImpl.reviewDelete(reviewID);
    }
}
