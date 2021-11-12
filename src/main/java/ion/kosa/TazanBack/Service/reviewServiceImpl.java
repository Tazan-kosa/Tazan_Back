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
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class reviewServiceImpl implements  reviewService {

    private final reviewDAO reviewDAO;

    @Override
    public List<reviewVO> myReviewList(int userID) {
        List<reviewVO> voList = new ArrayList<>();
        List<Review> reviewList =reviewDAO.myReviewList(userID);
        Iterator iterator = reviewList.iterator();
        while(iterator.hasNext()){
            Review review = (Review)iterator.next();
            voList.add(dataToVO(review));
        }
        return voList;
    }

    @Override
    public int reviewUpload(reviewVO reviewVO) {
        Review review = voToData(reviewVO);
        reviewDAO.reviewUpload(review);
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
        vo.setReviewThumbnail(review.getReviewThumbnail());
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
    public List<reviewVO> reviewRecent() {
        return reviewDAO.reviewRecent();
    }

    @Override
    public void reviewDelete(int reviewID) {
        reviewDAO.reviewDelete(reviewID);
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
        newReview.setReviewID(reviewVO.getReviewID());
        newReview.setReviewContent(reviewVO.getReviewContent());
        newReview.setReviewThumbnail(reviewVO.getReviewThumbnail());
        return newReview;
    }

    @Override
    public void reviewUpdate(reviewVO reviewVO) {
        reviewDAO.reviewUpdate(voToData(reviewVO));
    }


}