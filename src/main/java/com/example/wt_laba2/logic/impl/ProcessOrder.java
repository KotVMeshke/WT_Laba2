package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.bean.JSPNameList;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.dao.OrderDao;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.exception.ServiceException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.logic.ICommand;
import com.example.wt_laba2.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 * The ProcessOrder class implements ICommand to handle processing user orders.
 * It interacts with the OrderDao to create an order based on the products in the user's cart.
 */
public class ProcessOrder implements ICommand {

    /**
     * Executes the action to process an order based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information about the user's order.
     * @return A String representing the JSP name to navigate after processing the order.
     * @throws CommandException           If an error occurs while executing the order processing action.
     * @throws ParserConfigurationException If there's an issue with the parser configuration.
     * @throws IOException                If an I/O exception occurs during execution.
     * @throws DAOException               If there's an issue with the Data Access Object.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        OrderDao orderDao = null;
        OrderService orderService = null;
        try {
            String address = request.getParameter("address");
            orderDao = DAOFactory.getFactory().getOrderDao();
            List<CartItem> cart = (ArrayList<CartItem>) request.getSession().getAttribute("cart");

            orderService.createOrder(address,cart);

            request.getSession().removeAttribute("cart");
        } catch (ServiceException ex) {
            throw new CommandException("Error occurred while processing the order.", ex);
        }
        return JSPNameList.MAIN_PAGE;
    }
}

