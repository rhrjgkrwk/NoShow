package com.newface.action.menu;

import com.newface.controller.CommandAction;
import com.newface.dao.MenuDAO;
import com.newface.domain.Menu;
import com.newface.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by HeemangHan on 2016. 9. 8..
 */
public class MenuListAction implements CommandAction {
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        List<Menu> menuList = null;
        SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);

        int restaurantNo = Integer.parseInt(request.getParameter("idx"));

        try {
            MenuDAO menuDAO = sqlSession.getMapper(MenuDAO.class);

            menuList = menuDAO.selectMenuByRestaurant(restaurantNo);
        } finally {
            sqlSession.close();
        }

        request.setAttribute("menuList", menuList);

        return "menuList.jsp";
    }
}
