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

public class RemoveProductFromCart implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        ProductDao productDao = null;
        try {
            productDao = DAOFactory.getFactory().getProductDao();
            int productId = Integer.parseInt(request.getParameter("productId"));

            List<CartItem> cart = (List<CartItem>) request.getSession().getAttribute("cart");
           removeItemByProductName(cart, Integer.parseInt(request.getParameter("productId")));
            request.getSession().setAttribute("cart", cart);
        } catch (Exception ex) {
            throw new CommandException("Cart item remove exception");
        }

        return JSPNameList.CART_PAGE;
    }

    public void removeItemByProductName(List<CartItem> cart, int productId) {
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
