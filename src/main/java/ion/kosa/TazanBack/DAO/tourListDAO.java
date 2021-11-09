package ion.kosa.TazanBack.DAO;

import ion.kosa.TazanBack.VO.tourItemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface tourListDAO {
    public List<tourItemVO> selectAll();
    public List<tourItemVO> selectTopFour();
    public List<tourItemVO> selectKeyword(String keyword);
    List<tourItemVO> selectDate(String startdate, String enddate);
    public tourItemVO selectTourID(int tourID);
}
