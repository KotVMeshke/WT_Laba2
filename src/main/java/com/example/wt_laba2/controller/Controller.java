package com.example.wt_laba2.controller;

import com.example.wt_laba2.bean.JSPNameList;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.factory.ConnectionPoolFactory;
import com.example.wt_laba2.logic.*;
import com.example.wt_laba2.pool.ConnectionPool;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class Controller.
 * <p>
 * Manages HTTP requests and responses for the application.
 */
@MultipartConfig
public class Controller extends HttpServlet {

    public Controller() {
        super();
    }

//    private static Logger logger = LogManager.getLogger(Controller.class);
    /**
     * Initializes the servlet.
     * Establishes the database connection pool.
     *
     * @throws ServletException if an error occurs during initialization
     */
    @Override
    public void init() throws ServletException {
        try {

            ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
            connectionPool.CreateConnections();

        } catch (ClassNotFoundException e) {
//            logger.error("ERROR: " + e.getMessage());
            System.out.println("ERROR: " + e.getMessage());
        } catch (SQLException ex) {
//            logger.error("ERROR: " + ex.getMessage());
            System.out.println("ERROR: " + ex.getMessage());


        }
    }
    /**
     * Handles HTTP GET requests.
     * Retrieves the requested page content and forwards the request to the appropriate JSP page.
     *
     * @param req  the HttpServletRequest object
     * @param resp the HttpServletResponse object
     * @throws ServletException if an error occurs while processing the request
     * @throws IOException      if an I/O error occurs while handling the request
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        JSPPAge pageContent = JSPHelper.getJspHelper().getPage(requestURI);
        String page;
        if (req.getSession().getAttribute("language") == null) {
            req.getSession().setAttribute("language", "en");
        }

        try {
            page = pageContent.execute(req);
        } catch (CommandException e) {
//            logger.error("ERROR: Page exception in Controller " + e.toString());
            System.out.println("ERROR: Page exception in Controller " + e.getMessage());

            page = JSPNameList.ERROR_PAGE;
            req.setAttribute("error", e.getMessage());

        } catch (Exception e) {
//            logger.error("ERROR: Page exception in Controller " + e.toString());
            page = JSPNameList.ERROR_PAGE;
            System.out.println("ERROR: Page exception in Controller " + e.getMessage());

            req.setAttribute("error", e.getMessage());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(page);

        if (dispatcher != null) {
            dispatcher.forward(req, resp);
        } else {
            //LOG
            System.out.println("RequestDispatcher is NULL");
            errorMessageDireclyFromresponse(resp);
        }

    }

    /**
     * Handles HTTP POST requests.
     * Executes the requested command and forwards the request to the appropriate result page.
     *
     * @param req  the HttpServletRequest object
     * @param resp the HttpServletResponse object
     * @throws ServletException if an error occurs while processing the request
     * @throws IOException      if an I/O error occurs while handling the request
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter(RequestCommandName.COMMAND_NAME);
        String so = req.getParameter("productName");
        String result = null;
        ICommand command = CommandHelper.getCommandHelper().getCommand(commandName);
        try {
            result = command.execute(req);
        } catch (CommandException ex) {
            result = JSPNameList.ERROR_PAGE;
            req.setAttribute("error", ex.getMessage());
            System.out.println("ERROR: Page exception in Cotroller " + ex.getMessage());

        } catch (Exception ex) {
            result = JSPNameList.ERROR_PAGE;
            req.setAttribute("error", ex.getMessage());
            System.out.println("ERROR: Page exception in Cotroller " + ex.getMessage());

        }
//        resp.sendRedirect(result);

        RequestDispatcher dispatcher = req.getRequestDispatcher(result);
        if (dispatcher != null) {
            dispatcher.forward(req, resp);
        } else {
            errorMessageDireclyFromresponse(resp);
        }
    }
    /**
     * Sends an error message directly in the response if the dispatcher is null.
     *
     * @param response the HttpServletResponse object
     * @throws IOException if an I/O error occurs while writing the error message
     */
    private void errorMessageDireclyFromresponse(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("E R R O R");
    }
}
