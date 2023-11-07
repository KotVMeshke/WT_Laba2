package com.example.wt_laba2.controller;

import com.example.wt_laba2.exception.CommandException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.wt_laba2.logic.CommandHelper;
import com.example.wt_laba2.logic.CommandName;
import com.example.wt_laba2.logic.ICommand;


import java.io.IOException;
import java.io.PrintWriter;

public class Controller extends HttpServlet {

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter(RequestCommandName.COMMAND_NAME);
        String result = null;
        ICommand command = CommandHelper.getCommandHelper().getCommand(commandName);
        try{
            result = command.execute(req);
        }catch (CommandException ex){
            result = "Error";
        }catch (Exception ex) {
            result = "Error";
        }

//        RequestDispatcher dispatcher = req.getRequestDispatcher(result);
//        if (dispatcher != null){
//            dispatcher.forward(req, resp);
//        } else{
//            errorMessageDireclyFromresponse(resp);
//        }
        resp.sendRedirect(result);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter(RequestCommandName.COMMAND_NAME);
        String result = null;
        StringBuffer page = req.getRequestURL();
        ICommand command = CommandHelper.getCommandHelper().getCommand(commandName);
        try{
            result = command.execute(req);
        }catch (CommandException ex){
            result = "Error";
        }catch (Exception ex) {
            result = "Error";
        }
        resp.sendRedirect(result);
//        RequestDispatcher dispatcher = req.getRequestDispatcher(result);
//        if (dispatcher != null){
//            dispatcher.forward(req, resp);
//        } else{
//            errorMessageDireclyFromresponse(resp);
//        }
    }
    private void errorMessageDireclyFromresponse(HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        response.getWriter().println("E R R O R");
    }
}
