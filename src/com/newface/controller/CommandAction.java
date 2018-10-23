package com.newface.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HeemangHan on 2016. 8. 25..
 */
public interface CommandAction {
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
