package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.DAO.reviewDAO;
import ion.kosa.TazanBack.VO.reviewContentVO;
import ion.kosa.TazanBack.VO.reviewVO;
import ion.kosa.TazanBack.model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class reviewServiceImpl implements  reviewService {

    private final reviewDAO reviewDAO;

    @Override
    public int reviewUpload(reviewVO reviewVO) {
        Review review = voToData(reviewVO);
        reviewDAO.reviewUpload(review);
        System.out.println("impl : " + review.getReviewID());
        return review.getReviewID();
    }

    @Override
    public reviewVO reviewDownload(int reviewID) {
        return dataToVO(reviewDAO.reviewDownload(reviewID));
    }

    @Override
    public reviewVO dataToVO(Review review) {
        reviewVO vo = new reviewVO();
        vo.setReviewDate(review.getReviewDate());
        vo.setEndDate(review.getEndDate());
        vo.setStartDate(review.getStartDate());
        vo.setRegion(review.getRegion());
        vo.setReviewContent(review.getReviewContent());
        vo.setReviewTitle(review.getReviewTitle());
        vo.setPlanID(review.getPlanID());
        vo.setReviewID(review.getReviewID());
        vo.setUserID(review.getUserID());
        vo.setNickName(review.getNickName());
        return vo;
    }

    @Override
    public List<Review> reviewList() {
        return reviewDAO.reviewList();
    }

    @Override
    public List<reviewVO> selectKeyword(String keyword) {
        return reviewDAO.selectKeyword(keyword);
    }

    @Override
    public List<reviewVO> selectDate(String startdate, String enddate) {
        return reviewDAO.selectDate(startdate,enddate);
    }

    @Override
    public Review voToData(reviewVO reviewVO) {
        Review newReview = new Review();
        newReview.setReviewDate(reviewVO.getReviewDate());
        newReview.setReviewTitle(reviewVO.getReviewTitle());
        newReview.setStartDate(reviewVO.getStartDate());
        newReview.setEndDate(reviewVO.getEndDate());
        newReview.setRegion(reviewVO.getRegion());
        newReview.setPlanID(reviewVO.getPlanID());
        newReview.setUserID(reviewVO.getUserID());
        newReview.setReviewContent(reviewVO.getReviewContent());
//        String reviewContentVOS = reviewVO.getReviewContent();
//        Iterator iterator = reviewContentVOS.iterator();
//        String splicekeword_img = "$^^$";
//        String splicekeword_content = "@^^@";
//        String content = "";
//
//        //리뷰 내용 조회
//        while (iterator.hasNext()) {
//
//            //글,그림 가져오기
//            reviewContentVO contentVO = (reviewContentVO) iterator.next();
//
//            //작성된 글 추출
//            content+=contentVO.getReviewContent();
//
//            //이미지 존재시
//            if(contentVO.getReviewImage()!=null) {
//                try {
//
//                    //이미지 임을 표시
//                    content+=splicekeword_img;
//
//                    //저장 경로 생성
//                    Path path = Paths.get(FILE_PATH + contentVO.getReviewImage().getOriginalFilename());
//
//                    //경로에 저장
//                    contentVO.getReviewImage().transferTo(path);
//
//                    //이미지 경로 추가
//                    content+=path;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            //글 내용 추가
//            content+=splicekeword_content;
//        }
//        newReview.setReviewContent(content);
        return newReview;
    }
}