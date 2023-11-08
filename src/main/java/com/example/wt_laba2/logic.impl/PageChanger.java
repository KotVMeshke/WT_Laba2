package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.controller.RequestCommandName;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.logic.CommandName;
import com.example.wt_laba2.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class PageChanger implements ICommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        return request.getParameter(RequestCommandName.PAGE_NAME);
    }
}
