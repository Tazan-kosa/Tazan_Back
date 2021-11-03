package ion.kosa.TazanBack.Service;

import ion.kosa.TazanBack.VO.tourItemVO;

import java.util.List;

public interface tourListService {
    List<tourItemVO> selectAll();
    List<tourItemVO> selectTopFour();
    List<tourItemVO> selectKeyword(String keyword);
    List<tourItemVO> selectDate(String startdate,String enddate);
}
