package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.VO.tourItemVO;

import java.util.List;

public interface tourListService {
    List<tourItemVO> selectAll();
    List<tourItemVO> selectTopFour();
    List<tourItemVO> selectKeyword(String keyword,String startdate,String enddate);
//    List<tourItemVO> selectDate(String startdate,String enddate);
    tourItemVO selectTourID(int tourID);
    List<tourItemVO> searchRegion(String keyword);
    void tourDelete(int tourID);
    void updateTour(tourItemVO tourItemVO);
    void insertTour(tourItemVO tourItemVO);
}
