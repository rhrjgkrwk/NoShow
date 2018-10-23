package com.newface.filter;

import com.newface.domain.Member;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by HeemangHan on 2016. 8. 30..
 */
public class Filter implements javax.servlet.Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        request.setCharacterEncoding("UTF-8");

        String uri = request.getRequestURI();
        System.out.println("  => Request URI: " + uri);

        if((uri.indexOf("login.do") < 0) && (uri.indexOf("join.do") < 0)) {
            Member member = (Member) session.getAttribute("member");
            if(member != null)
                System.out.println("  => ID: " + member.getMemberId());

            if(member == null || member.getMemberId().trim().length() == 0) {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendRedirect("/index.jsp");
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
