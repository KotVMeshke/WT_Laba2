package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.JSPNameList;
import com.example.wt_laba2.dao.UserDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class RemoveBan implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        UserDao userDao = null;
        try {
            userDao = DAOFactory.getFactory().getUserDao();
            int userId = Integer.parseInt(request.getParameter("userId"));
            if (userId <= 0) {
                throw new CommandException("Incorrect user id");
            }

            userDao.removeBan(userId);
        } catch (DAOException ex) {
            throw new CommandException("Can't get XmlDao", ex);
        }

        return JSPNameList.ADMINISTRATOR_PAGE;
    }
}

