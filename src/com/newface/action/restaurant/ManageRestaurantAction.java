package com.newface.action.restaurant;

import com.newface.controller.CommandAction;
import com.newface.dao.MenuDAO;
import com.newface.dao.RestaurantDAO;
import com.newface.domain.Member;
import com.newface.domain.Menu;
import com.newface.domain.Restaurant;
import com.newface.mybatis.MyBatisConfig;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by HeemangHan on 2016. 9. 20..
 */
public class ManageRestaurantAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        HttpSession session = request.getSession();

        Member member = null;
        Restaurant restaurant = null;
        List<Menu> menuList = null;

        SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);

        try {
            RestaurantDAO restaurantDAO = sqlSession.getMapper(RestaurantDAO.class);
            MenuDAO menuDAO = sqlSession.getMapper(MenuDAO.class);

            member = (Member) session.getAttribute("member");
            restaurant = restaurantDAO.selectOneByMemberId(member.getMemberNo());
            menuList = menuDAO.selectMenuByRestaurant(restaurant.getRestaurantNo());

            request.setAttribute("menuList", menuList);
            request.setAttribute("restaurant", restaurant);

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            sqlSession.close();
        }
        return "manage.jsp";
    }
}
