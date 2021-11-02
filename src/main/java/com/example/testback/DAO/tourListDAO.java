package com.example.testback.DAO;

import com.example.testback.VO.tourItemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface tourListDAO {
    public List<tourItemVO> selectAll();
    public List<tourItemVO> selectTopFour();
    public List<tourItemVO> selectKeyword(String keyword);
    List<tourItemVO> selectDate(String startdate, String enddate);
}
