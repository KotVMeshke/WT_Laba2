package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.SessionAtributes;
import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.dao.UserDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignIn implements ICommand {
    @Override
    public String execute(HttpServletRequest request)throws CommandException, ParserConfigurationException, IOException, DAOException {
        UserDao userDao = null;
        List<Object> list = new ArrayList<>();
        try {
            userDao = DAOFactory.getFactory().getUserDao();
            User user = userDao.signIn(request.getParameter("Login"),request.getParameter("Password"));
            request.setAttribute("SomeMessage","Successful LogIn");
            request.getSession().setAttribute(SessionAtributes.Authorized,true);
            request.getSession().setAttribute(SessionAtributes.UserId, user.getId());
            request.getSession().setAttribute(SessionAtributes.isAdmin, user.getRole());

        }catch (DAOException ex){
            throw new CommandException("LogIn troubles, oops",ex);
        }
        return "MainPage.jsp";
    }
}
