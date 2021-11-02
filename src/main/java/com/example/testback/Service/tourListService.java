package com.example.testback.Service;

import com.example.testback.VO.tourItemVO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface tourListService {
    List<tourItemVO> selectAll();
    List<tourItemVO> selectTopFour();
    List<tourItemVO> selectKeyword(String keyword);
    List<tourItemVO> selectDate(String startdate,String enddate);
}
