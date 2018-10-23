package com.newface.action.restaurant;

import com.newface.controller.CommandAction;
import com.newface.dao.RestaurantDAO;
import com.newface.domain.Member;
import com.newface.domain.Restaurant;
import com.newface.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by HeemangHan on 2016. 9. 14..
 */
public class RegistRestaurantAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");

        int idx = -1;

        Restaurant restaurant = new Restaurant();
        Member member = (Member) session.getAttribute("member");

        restaurant.setRestaurantRegnum(request.getParameter("regnum"));
        restaurant.setRestaurantName(request.getParameter("name"));
        restaurant.setRestaurantAddress(request.getParameter("address"));
        restaurant.setRestaurantTel(request.getParameter("tel"));
        restaurant.setRestaurantLatitude(Float.parseFloat(request.getParameter("lat")));
        restaurant.setRestaurantLongitude(Float.parseFloat(request.getParameter("lng")));
        restaurant.setMember(member);
        restaurant.setRestaurantState("W");

        SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);

        try {
            RestaurantDAO restaurantDAO = sqlSession.getMapper(RestaurantDAO.class);

            idx = restaurantDAO.add(restaurant);
        } finally {
            sqlSession.close();
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.println("<script>");
        out.println("alert('신청 완료.');");
        out.println("location.href='main.jsp';");
        out.println("</script>");
        out.close();

        return null;
    }
}
