package com.example.wt_laba2.controller;

import com.example.wt_laba2.exception.CommandException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.wt_laba2.logic.CommandHelper;
import com.example.wt_laba2.logic.CommandName;
import com.example.wt_laba2.logic.ICommand;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.println("<h2>sdfsdds</h2>");
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
        RequestDispatcher dispatcher = req.getRequestDispatcher(result);
        if (dispatcher != null){
            dispatcher.forward(req, resp);
        } else{
            errorMessageDireclyFromresponse(resp);
        }
    }
    private void errorMessageDireclyFromresponse(HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        response.getWriter().println("E R R O R");
    }
}
