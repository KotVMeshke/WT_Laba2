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


public class Register implements ICommand {
    @Override
    public String execute(HttpServletRequest request)throws CommandException {
        User user = new User();
        UserDao userDao = null;
        try {
            userDao = DAOFactory.getFactory().getUserDao();
            user.setLogin(request.getParameter("Login"));
            user.setPassword(request.getParameter("Password"));
            if (user.getPassword().equals(request.getParameter("confirm-password"))){
                int userId = userDao.registration(user);
                request.setAttribute("SomeMessage","Successful registration");
                request.getSession().setAttribute(SessionAtributes.Authorized,true);
                request.getSession().setAttribute(SessionAtributes.UserId, userId);
            }else
            {
                request.setAttribute("IncorrectData", "Passwords are not the same");
            }

        }catch (DAOException ex){
            throw new CommandException("Can't get XmlDao",ex);
        }
        return "MainPage.jsp";
    }
}
