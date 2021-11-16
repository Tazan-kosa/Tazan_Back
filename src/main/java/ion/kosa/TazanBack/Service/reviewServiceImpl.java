package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.DAO.reviewDAO;
import ion.kosa.TazanBack.VO.commentVO;
import ion.kosa.TazanBack.VO.reviewVO;
import ion.kosa.TazanBack.model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class reviewServiceImpl implements  reviewService {

    private final reviewDAO reviewDAO;
    private final planServiceImpl planService;
    private final commentServiceImpl commentService;

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
    public reviewVO myReviewSelect(int planID) {
        Review r = reviewDAO.myReviewSelect(planID);
        if (r == null) return null;
        return dataToVO(r);
    }

    @Override
    public int reviewUpload(reviewVO reviewVO) {
        Review review = voToData(reviewVO);
        reviewDAO.reviewUpload(review);
        planService.updateReviewFlag(reviewVO.getPlanID());
        return review.getReviewID();
    }

    @Override
    public reviewVO reviewDownload(int reviewID) {
        reviewVO rv = dataToVO(reviewDAO.reviewDownload(reviewID));
        List<commentVO> commentVO = commentService.selectComment(reviewID);
        if(commentVO == null) rv.setCommentVO(null);
        else rv.setCommentVO(commentVO);
        return rv;
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
        if(review.getReviewThumbnail() == null){
            review.setReviewThumbnail("https://user-images.githubusercontent.com/37900920/141242967-16a7888c-76ba-4a7b-b9e7-7fceb9a727aa.png");
        }
        vo.setReviewThumbnail(review.getReviewThumbnail());
        return vo;
    }

    @Override
    public List<reviewVO> reviewList() {
        return dataListToVOList(reviewDAO.reviewList());
    }
    @Override
    public List<reviewVO> reviewmanageList() {
        return dataListToVOList(reviewDAO.reviewmanageList());
    }

    @Override
    public List<reviewVO> selectKeyword(String keyword,String startdate,String enddate) {
        return dataListToVOList(reviewDAO.selectKeyword(keyword,startdate,enddate));
    }

    @Override
    public List<reviewVO> reviewRecent() {
        return dataListToVOList(reviewDAO.reviewRecent());
    }

    @Override
    public List<reviewVO> dataListToVOList(List<Review> review) {
        List<reviewVO> rv = new ArrayList();
        for (Review r: review) {
            rv.add(dataToVO(r));
        }
        return rv;
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