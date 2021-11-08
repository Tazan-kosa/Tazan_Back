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

    //    @PostMapping("/review/upload")
////    public ResponseEntity reviewUpload(@RequestBody reviewVO reviewVO){
//    public String reviewUpload(@RequestBody reviewVO reviewVO){
//
//        //        reviewServiceImpl.reviewUpload(reviewVO);
//        System.out.println("review data 도착했습니다.");
//        System.out.println(reviewVO);
//        MultipartFile file = (MultipartFile)(reviewVO.getReviewContent()).get(1);
//        System.out.println();
//        return "잘 왔슈";
//    }
    @PostMapping(value="/review/upload")
    public void reviewUpload(@RequestBody reviewVO reviewVO){
//        System.out.println("review data 도착했습니다.");
//        System.out.println(reviewVO.getPlanID());
//        System.out.println(reviewVO.getUserID());
//        System.out.println(reviewVO.getStartDate());
//        System.out.println(reviewVO.getEndDate());
//        System.out.println(reviewVO.getReviewDate());
//        System.out.println(reviewVO.getRegion());
//        System.out.println(reviewVO.getReviewTitle());
        reviewServiceImpl.reviewUpload(reviewVO);
//        return "잘 왔슈";
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
        System.out.println(reviewid);
        return reviewServiceImpl.reviewDownload(reviewid);
    }

    @GetMapping("/review/reviewList")
    public @ResponseBody List<Review> reviewList() {
        return reviewServiceImpl.reviewList();
    }
}
