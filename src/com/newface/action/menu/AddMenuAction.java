package com.newface.action.menu;

import com.google.gson.Gson;
import com.newface.controller.JCommandAction;
import com.newface.dao.MenuDAO;
import com.newface.dao.RestaurantDAO;
import com.newface.domain.Member;
import com.newface.domain.Menu;
import com.newface.domain.Restaurant;
import com.newface.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by HeemangHan on 2016. 9. 20..
 */
public class AddMenuAction implements JCommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        Menu menu = new Menu();
        String requestJson = request.getParameter("json");
        String responseJson = null;

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(requestJson);

        Member member = null;
        Restaurant restaurant = null;

        int menuNum = Integer.parseInt(jsonObject.get("menuNum").toString()) + 1;
        String menuName = jsonObject.get("menuName").toString();
        int menuPrice = Integer.parseInt(jsonObject.get("menuPrice").toString());
        String menuDescription = jsonObject.get("menuDescription").toString();

        SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);

        try {
            RestaurantDAO restaurantDAO = sqlSession.getMapper(RestaurantDAO.class);
            MenuDAO menuDAO = sqlSession.getMapper(MenuDAO.class);

            member = (Member) session.getAttribute("member");
            restaurant = restaurantDAO.selectOneByMemberId(member.getMemberNo());

            menu.setMenuNum(menuNum);
            menu.setMenuName(menuName);
            menu.setMenuPrice(menuPrice);
            menu.setMenuDescription(menuDescription);
            menu.setRestaurant(restaurant);

            int menuNo = menuDAO.addMenu(menu);
            menu.setMenuNo(menuNo);

            responseJson = gson.toJson(menu);

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return responseJson;
    }
}
