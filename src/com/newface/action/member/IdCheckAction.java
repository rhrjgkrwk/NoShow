package com.newface.action.member;

import com.newface.controller.JCommandAction;
import com.newface.dao.MemberDAO;
import com.newface.domain.Member;
import com.newface.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HeemangHan on 2016. 9. 6..
 */
public class IdCheckAction implements JCommandAction {
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("UTF-8");
        JSONObject jsonObject = new JSONObject();

        String memberId = request.getParameter("member_id");
        boolean flag = false;

        SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);

        try {
            MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);

            String id = memberDAO.getId(memberId);

            flag = (id != null) ? true : false;
        } finally {
            sqlSession.close();
        }

        jsonObject.put("flag", flag);

        return jsonObject.toJSONString();
    }
}
