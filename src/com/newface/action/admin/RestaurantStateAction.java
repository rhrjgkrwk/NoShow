package com.newface.action.admin;

import com.newface.controller.JCommandAction;
import com.newface.dao.RestaurantDAO;
import com.newface.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HeemangHan on 2016. 9. 14..
 */
public class RestaurantStateAction implements JCommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        JSONObject jsonObject = new JSONObject();

        int restaurantNo = Integer.parseInt(request.getParameter("restaurantNo"));
        String restaurantState = request.getParameter("restaurantState");
        String memberType = request.getParameter("memberType");
        String status = null;
        int flag = -1;

        SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);

        try {
            RestaurantDAO restaurantDAO = sqlSession.getMapper(RestaurantDAO.class);

            flag = restaurantDAO.updateRestaurantState(restaurantNo, restaurantState, memberType);

            if(flag == 1)
                status = restaurantState;

        } finally {
            sqlSession.close();
        }

        jsonObject.put("status", status);

        return jsonObject.toJSONString();
    }
}
