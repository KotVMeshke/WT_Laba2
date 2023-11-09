package com.example.wt_laba2.controller;

import com.example.wt_laba2.bean.JSPNameList;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.logic.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

public class Controller extends HttpServlet {

    public Controller() {
        super();
    }

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver exception");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        JSPPAge pageContent = JSPHelper.getJspHelper().getPage(requestURI);
        String page;

        // LOG
        System.out.println("URI " + requestURI + " received");

        try {
            page = pageContent.execute(req);
        } catch (CommandException e) {
            //LOG
            System.out.println("Page exception in Controller " + e.toString());
            page = JSPNameList.ERROR_PAGE;
        } catch (Exception e) {
            //LOG
            System.out.println("Exception in Controller " + e.toString());
            page =  JSPNameList.ERROR_PAGE;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter(RequestCommandName.COMMAND_NAME);
        String result = null;
        StringBuffer page = req.getRequestURL();
        ICommand command = CommandHelper.getCommandHelper().getCommand(commandName);
        try {
            result = command.execute(req);
        } catch (CommandException ex) {
            result =  JSPNameList.ERROR_PAGE;
        } catch (Exception ex) {
            result =  JSPNameList.ERROR_PAGE;
        }
//        resp.sendRedirect(result);
        RequestDispatcher dispatcher = req.getRequestDispatcher(result);
        if (dispatcher != null) {
            dispatcher.forward(req, resp);
        } else {
            errorMessageDireclyFromresponse(resp);
        }
    }

    private void errorMessageDireclyFromresponse(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("E R R O R");
    }
}
