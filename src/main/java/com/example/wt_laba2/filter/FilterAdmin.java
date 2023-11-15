package com.example.wt_laba2.filter;

import com.example.wt_laba2.bean.SessionAtributes;
import com.example.wt_laba2.logic.JSPName;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * FilterAdmin is a filter that checks if the user has admin privileges before allowing access to specific resources.
 */
public class FilterAdmin extends HttpFilter {

    /**
     * Performs filtering on requests to resources, allowing access only to users with admin privileges.
     * @param req The HttpServletRequest object.
     * @param res The HttpServletResponse object.
     * @param chain The FilterChain object to proceed with the request.
     * @throws IOException If an input or output error occurs while the filter is handling the request.
     * @throws ServletException If the filter encounters difficulty while processing the request.
     */
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(false);

        Object isAdmin = session.getAttribute(SessionAtributes.isAdmin);

        if (isAdmin == null) {
            res.sendRedirect(JSPName.MAIN_PAGE.getUrlPattern());
        } else {
            chain.doFilter(req, res);
        }
    }
}
