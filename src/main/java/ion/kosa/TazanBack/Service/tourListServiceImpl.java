package ion.kosa.TazanBack.Service;


import ion.kosa.TazanBack.DAO.tourListDAO;
import ion.kosa.TazanBack.VO.tourItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class tourListServiceImpl implements tourListService{

    @Autowired
    private tourListDAO tourListDAO;

    @Override
    public List<tourItemVO> selectAll() {
        return tourListDAO.selectAll();
    }

    @Override
    public List<tourItemVO> selectTopFour() {
        return tourListDAO.selectTopFour();
    }

    @Override
    public List<tourItemVO> selectKeyword(String keyword, String startdate, String enddate) {
        return tourListDAO.selectKeyword(keyword,startdate,enddate);
    }

    @Override
    public List<tourItemVO> searchRegion(String keyword) {
        return tourListDAO.searchRegion(keyword);
    }

    @Override
    public tourItemVO selectTourID(int tourID) {
        return tourListDAO.selectTourID(tourID);
    }

    @Transactional
    public void tourDelete(int tourID){
        tourListDAO.tourDelete(tourID);
    }

    @Override
    public void updateTour(tourItemVO tourItemVO) {
        tourListDAO.updateTour(tourItemVO);
    }

    @Override
    public void insertTour(tourItemVO tourItemVO) {
        tourItemVO.setLikes(0);
        tourItemVO.setHeight(6);
        tourListDAO.insertTour(tourItemVO);
    }

    @Override
    public void updateTourLikePoint(int tourID) {
        tourListDAO.updateTourLikePoint(tourID);
    }

    @Override
    public void deleteTourLikePoint(int tourID) {
        tourListDAO.deleteTourLikePoint(tourID);
    }

}
