package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.JSPNameList;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.dao.UserDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.exception.ServiceException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.factory.ServiceFactory;
import com.example.wt_laba2.logic.ICommand;
import com.example.wt_laba2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * The SetBan class implements ICommand to handle setting a ban for a user.
 * It interacts with the UserDao to set a ban for a specific user based on the provided user ID.
 */
public class SetBan implements ICommand {

    /**
     * Executes the action to set a ban for a user based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information about the user and ban setting.
     * @return A String representing the JSP name to navigate after setting the ban.
     * @throws CommandException           If an error occurs while executing the ban setting action.
     * @throws ParserConfigurationException If there's an issue with the parser configuration.
     * @throws IOException                If an I/O exception occurs during execution.
     * @throws DAOException               If there's an issue with the Data Access Object.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        UserService userService = null;
        try {
            userService = ServiceFactory.getInstance().getUserService();
            int userId = Integer.parseInt(request.getParameter("userId"));
            userService.SetBan(userId);
        } catch (ServiceException ex) {
            throw new CommandException("Error occurred while setting the ban.", ex);
        }
        return JSPNameList.ADMINISTRATOR_PAGE;
    }
}

