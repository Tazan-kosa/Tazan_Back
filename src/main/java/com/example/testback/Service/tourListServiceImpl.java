package com.example.testback.Service;


import com.example.testback.DAO.tourListDAO;
import com.example.testback.VO.tourItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public List<tourItemVO> selectKeyword(String keyword) {
        return tourListDAO.selectKeyword(keyword);
    }

    @Override
    public List<tourItemVO> selectDate(String startdate, String enddate) {
        return tourListDAO.selectDate(startdate,enddate);
    }
}
