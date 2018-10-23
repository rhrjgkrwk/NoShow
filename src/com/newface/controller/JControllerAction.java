package com.newface.controller;

import org.json.simple.JSONObject;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by HeemangHan on 2016. 8. 25..
 */

public class JControllerAction extends HttpServlet {
    private Map commandMap = new HashMap(); // 명령어와 명령어 처리 클래스를 쌍으로 저장

    public void init(ServletConfig config) throws ServletException {
        loadProperties("com/newface/properties/JCommand");
    }

    private void loadProperties(String path) {
        ResourceBundle rbHome = ResourceBundle.getBundle(path);
        Enumeration<String> actionEnumHome = rbHome.getKeys();

        while(actionEnumHome.hasMoreElements()) {
            String command = actionEnumHome.nextElement();
            String className = rbHome.getString(command);

            try {
                Class commandClass = Class.forName(className);
                Object commandInstance = commandClass.newInstance();
                commandMap.put(command, commandInstance);
            } catch (ClassNotFoundException e) {
                continue;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestPro(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestPro(request, response);
    }

    private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = null;
        JCommandAction com = null;
        PrintWriter out = null;

        try {
            String command = request.getRequestURI();
            if(command.indexOf(request.getContextPath()) == 0) {
                command = command.substring(request.getContextPath().length());
            }

            com = (JCommandAction) commandMap.get(command);

            if(com == null) {
                System.out.println("not found : " + command);
                return;
            }

            json = com.requestPro(request, response);

            if(json == null) {
                return;
            }
        } catch (Throwable e) {
            throw new ServletException(e);
        }

        if(json == null)
            return;

        response.setContentType("application/json; charset=UTF-8");
        out = response.getWriter();
        out.print(json);
        out.close();

    }
}
