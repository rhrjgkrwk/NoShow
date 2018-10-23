package com.newface.action.admin;

import com.newface.controller.CommandAction;
import com.newface.dao.RestaurantDAO;
import com.newface.mybatis.MyBatisConfig;
import com.newface.domain.Restaurant;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by HeemangHan on 2016. 9. 7..
 */
public class RestaurantListAction implements CommandAction {
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        List<Restaurant> restaurantList = null;
        String url = null;

        if(request.getRequestURI().equals("/admin/restaurant.do"))
            url = "manageRestaurant.jsp";
        else
            url = "/restaurant/list.jsp";

        SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);

        try {
            RestaurantDAO restaurantDAO = sqlSession.getMapper(RestaurantDAO.class);

            restaurantList = restaurantDAO.selectAll();
        } finally {
            sqlSession.close();
        }

        request.setAttribute("restaurantList", restaurantList);

        return url;
    }
}
