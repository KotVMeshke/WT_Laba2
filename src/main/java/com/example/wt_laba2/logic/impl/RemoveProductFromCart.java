package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.bean.JSPNameList;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The RemoveProductFromCart class implements ICommand to handle removing a product from the cart.
 * It interacts with the cart in the session to remove the specified product from the list of items.
 */
public class RemoveProductFromCart implements ICommand {

    /**
     * Executes the action to remove a product from the cart based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information about the product to be removed from the cart.
     * @return A String representing the JSP name to navigate after removing the product from the cart.
     * @throws CommandException           If an error occurs while executing the remove product from cart action.
     * @throws ParserConfigurationException If there's an issue with the parser configuration.
     * @throws IOException                If an I/O exception occurs during execution.
     * @throws DAOException               If there's an issue with the Data Access Object.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        ProductDao productDao = null;
        try {
            productDao = DAOFactory.getFactory().getProductDao();
            int productId = Integer.parseInt(request.getParameter("productId"));

            List<CartItem> cart = (List<CartItem>) request.getSession().getAttribute("cart");
            removeItemByProductId(cart, productId);
            request.getSession().setAttribute("cart", cart);
        } catch (Exception ex) {
            throw new CommandException("Error occurred while removing the cart item.", ex);
        }

        return JSPNameList.CART_PAGE;
    }

    /**
     * Removes a specific product from the cart based on its product ID.
     *
     * @param cart      The list of cart items.
     * @param productId The ID of the product to be removed.
     */
    public void removeItemByProductId(List<CartItem> cart, int productId) {
        Iterator<CartItem> iterator = cart.iterator();
        while (iterator.hasNext()) {
            CartItem cartItem = iterator.next();
            if (cartItem.getProduct().getId() == productId) {
                iterator.remove();
                break;
            }
        }
    }
}

