package ion.kosa.TazanBack.DAO;

import ion.kosa.TazanBack.VO.tourItemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface tourListDAO {
    public List<tourItemVO> selectAll();
    public List<tourItemVO> selectTopFour();
    public List<tourItemVO> selectKeyword(String keyword,String startdate,String enddate);
    List<tourItemVO> searchRegion(String keyword);
    public tourItemVO selectTourID(int tourID);

}
