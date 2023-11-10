package com.example.wt_laba2.filter;

import com.example.wt_laba2.bean.SessionAtributes;
import com.example.wt_laba2.logic.JSPName;
import com.example.wt_laba2.logic.JSPPAge;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;

public class FilterProtector extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(false);

        Object id = session.getAttribute(SessionAtributes.UserId);
        Object isAdmin = session.getAttribute(SessionAtributes.isAdmin);

        if (id == null || isAdmin != null) {
            res.sendRedirect(JSPName.MAIN_PAGE.getUrlPattern());
        } else {
            chain.doFilter(req, res);
        }
    }
}
