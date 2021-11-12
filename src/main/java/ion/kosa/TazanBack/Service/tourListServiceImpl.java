package ion.kosa.TazanBack.Service;


import ion.kosa.TazanBack.DAO.tourListDAO;
import ion.kosa.TazanBack.VO.tourItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

//    @Override
//    public List<tourItemVO> selectDate(String startdate, String enddate) {
//        return tourListDAO.selectDate(startdate,enddate);
//    }

    @Override
    public tourItemVO selectTourID(int tourID) {
        return tourListDAO.selectTourID(tourID);
    }
}
