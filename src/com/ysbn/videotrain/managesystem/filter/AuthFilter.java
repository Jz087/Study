package com.ysbn.videotrain.managesystem.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 访问权限过滤器
 * @author David
 * @version 1.0
 */
public class AuthFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
                                                                                     throws IOException,
                                                                                     ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        HttpSession session = request.getSession();
        if (session.getAttribute("loginFlag") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } else {
            arg2.doFilter(arg0, arg1);
        }
    }

    public void init(FilterConfig arg0) throws ServletException {

    }
}