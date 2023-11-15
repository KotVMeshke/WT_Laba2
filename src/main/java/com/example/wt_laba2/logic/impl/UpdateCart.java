package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.bean.JSPNameList;
import com.example.wt_laba2.dao.OrderDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 * The UpdateCart class implements ICommand to handle updating items in the user's cart.
 * It allows modifying the quantity of a specific product in the cart.
 */
public class UpdateCart implements ICommand {

    /**
     * Executes the action to update the quantity of an item in the user's cart based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information for updating the cart.
     * @return A String representing the JSP name to navigate after updating the cart.
     * @throws CommandException           If an error occurs while executing the cart update action.
     * @throws ParserConfigurationException If there's an issue with the parser configuration.
     * @throws IOException                If an I/O exception occurs during execution.
     * @throws DAOException               If there's an issue with the Data Access Object.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        try {
            String str = request.getParameter("quantity");
            String id = request.getParameter("productId");

            List<CartItem> cart = (ArrayList<CartItem>) request.getSession().getAttribute("cart");
            for (CartItem object : cart) {
                if (object.getProduct().getId() == Integer.parseInt(id)) {
                    object.amount = Integer.parseInt(str);
                }
            }

            // Updating the cart in the session
            request.getSession().removeAttribute("cart");
            request.getSession().setAttribute("cart", cart);

        } catch (Exception ex) {
            throw new CommandException("Error occurred while updating the cart.", ex);
        }
        return JSPNameList.CART_PAGE;
    }
}

