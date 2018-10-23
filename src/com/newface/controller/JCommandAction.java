package com.newface.controller;

import org.json.simple.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HeemangHan on 2016. 8. 28..
 */
public interface JCommandAction {
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
