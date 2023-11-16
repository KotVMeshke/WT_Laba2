package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.JSPNameList;
import com.example.wt_laba2.bean.SessionAtributes;
import com.example.wt_laba2.bean.User;
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
import java.util.ArrayList;
import java.util.List;

/**
 * The SignIn class implements ICommand to handle user sign-in functionality.
 * It interacts with the UserDao to sign in a user based on provided login credentials.
 */
public class SignIn implements ICommand {

    /**
     * Executes the action to sign in a user based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information for user sign-in.
     * @return A String representing the JSP name to navigate after signing in the user.
     * @throws CommandException           If an error occurs while executing the sign-in action.
     * @throws ParserConfigurationException If there's an issue with the parser configuration.
     * @throws IOException                If an I/O exception occurs during execution.
     * @throws DAOException               If there's an issue with the Data Access Object.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        UserService userService = null;
        try {
           userService = ServiceFactory.getInstance().getUserService();

            User user = userService.signIn(request.getParameter("Login"), request.getParameter("Password"));
            request.setAttribute("SomeMessage", "Successful LogIn");
            request.getSession().setAttribute(SessionAtributes.Authorized, true);
            request.getSession().setAttribute(SessionAtributes.UserId, user.getId());
            request.getSession().setAttribute(SessionAtributes.isAdmin, user.getRole());

        } catch (ServiceException ex) {
            throw new CommandException("Incorrect Login or password.", ex);
        }
        return JSPNameList.MAIN_PAGE;
    }
}

