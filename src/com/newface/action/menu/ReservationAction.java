package com.newface.action.menu;

import com.google.gson.Gson;
import com.newface.controller.JCommandAction;
import com.newface.dao.MemberDAO;
import com.newface.dao.MenuDAO;
import com.newface.dao.ReservationDAO;
import com.newface.dao.RestaurantDAO;
import com.newface.domain.*;
import com.newface.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by HeemangHan on 2016. 9. 16..
 */
public class ReservationAction implements JCommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("UTF-8");

        SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
        String json = request.getParameter("json");
        String responseJson = null;

        Gson gson = new Gson();
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(json);

        int memberNo = Integer.parseInt(jsonObject.get("memberNo").toString());
        int restaurantNo = Integer.parseInt(jsonObject.get("restaurantNo").toString());
        String reservationRequest = jsonObject.get("reservationRequest").toString();

        String date = jsonObject.get("reservationDate").toString();
        Date reservationDate = Date.valueOf(date);

        String time = jsonObject.get("reservationTime").toString();
        Time reservationTime = Time.valueOf(time);

        Reservation reservation = new Reservation();

        reservation.setReservationRequest(reservationRequest);
        reservation.setReservationDate(reservationDate);
        reservation.setReservationTime(reservationTime);

        JSONArray menuArray = (JSONArray) jsonObject.get("menu");

        try {
            MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
            RestaurantDAO restaurantDAO = sqlSession.getMapper(RestaurantDAO.class);
            ReservationDAO reservationDAO = sqlSession.getMapper(ReservationDAO.class);
            MenuDAO menuDAO = sqlSession.getMapper(MenuDAO.class);

            Member member = memberDAO.selectByNo(memberNo);
            Restaurant restaurant = restaurantDAO.selectOne(restaurantNo);

            reservation.setMember(member);
            reservation.setRestaurant(restaurant);

            reservationDAO.addReservation(reservation);

            ReservationMenu reservationMenu = new ReservationMenu();
            reservationMenu.setReservation(reservation);

            for(int i=0; i<menuArray.size(); i++) {
                JSONObject menuObject = (JSONObject) menuArray.get(i);

                int menuNum = Integer.parseInt(menuObject.get("menuNum").toString());
                int menuCount = Integer.parseInt(menuObject.get("menuCount").toString());

                Menu menu = menuDAO.selectMenuByNum(restaurantNo, menuNum);

                reservationMenu.setMenu(menu);
                reservationMenu.setMenuCount(menuCount);

                reservationDAO.addReservationMenu(reservationMenu);

                responseJson = gson.toJson(reservation);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return responseJson;
    }
}
