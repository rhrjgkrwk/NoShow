package com.newface.action.member;

import com.newface.controller.CommandAction;
import com.newface.dao.MemberDAO;
import com.newface.mybatis.MyBatisConfig;
import com.newface.domain.Member;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by HeemangHan on 2016. 9. 11..
 */
public class MemberListAction implements CommandAction {
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        List<Member> memberList = null;

        SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);

        try {
            MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);

            memberList = memberDAO.selectAll();
        } finally {
            sqlSession.close();
        }

        request.setAttribute("memberList", memberList);

        return "memberList.jsp";
    }
}
