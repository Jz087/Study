package com.ysbn.videotrain.managesystem.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hctn.dev.toolkit.util.Utility;

/**
 * @author xuzl
 * @version 创建时间：2012-2-1 下午02:55:11
 */

public class LimitFilter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse,
                         FilterChain filterchain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletrequest;
        HttpServletResponse response = (HttpServletResponse) servletresponse;
        HttpSession session = request.getSession();
        String reqUrl = request.getRequestURI().replace(request.getContextPath(), "");
        RequestDispatcher dispatcher = null;

        if (session.getAttribute("loginFlag") == null) {
            //未登录用户，转登录页面
            Utility.Log.d(LimitFilter.class, "非法访问！");
            dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            //已登录用户，做权限检查
            if (session.getAttribute("loginFlag").equals("1")) {
                dispatcher = request.getRequestDispatcher(reqUrl);
                dispatcher.forward(request, response);
            } else {
                dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    public void init(FilterConfig filterconfig) throws ServletException {

    }

}
