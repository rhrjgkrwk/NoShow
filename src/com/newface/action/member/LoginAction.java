package com.newface.action.member;

import com.newface.controller.CommandAction;
import com.newface.dao.MemberDAO;
import com.newface.domain.Member;
import com.newface.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by HeemangHan on 2016. 8. 27..
 */
public class LoginAction implements CommandAction {
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String memberId = request.getParameter("login_id");
        String memberPw = request.getParameter("login_pw");
        String path = null;

        SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);

        try {
            MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);

            Member member = memberDAO.login(memberId, memberPw);

            if(member != null) {
                HttpSession session = request.getSession();
                session.setAttribute("member", member);

                path = "main.jsp";
            } else {
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();

                out.println("<script>");
                out.println("alert('로그인 정보가 올바르지 않습니다.');");
                out.println("location.href='index.jsp';");
                out.println("</script>");
                out.close();
            }
        } finally {
            sqlSession.close();
        }

        return path;
    }
}