package com.newface.action.member;

import com.newface.dao.MemberDAO;
import com.newface.domain.Member;
import com.newface.controller.CommandAction;
import com.newface.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HeemangHan on 2016. 9. 6..
 */
public class JoinAction implements CommandAction {
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        request.setCharacterEncoding("UTF-8");
        int idx = -1;

        Member member = new Member();

        member.setMemberId(request.getParameter("member_id"));
        member.setMemberPw(request.getParameter("member_password"));
        member.setMemberName(request.getParameter("member_name"));
        member.setMemberTel(request.getParameter("member_tel"));
        member.setMemberState("A");
        member.setMemberType("USR001");

        SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);

        try {
            MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
            idx = memberDAO.add(member);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        request.setAttribute("idx", idx);
        return "index.jsp";
    }
}