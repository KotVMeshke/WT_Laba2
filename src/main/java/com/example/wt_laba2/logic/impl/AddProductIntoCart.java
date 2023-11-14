package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.*;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddProductIntoCart implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        ProductDao productDao = null;
        try {
            productDao = DAOFactory.getFactory().getProductDao();
            int productId = Integer.parseInt(request.getParameter("productId"));

            List<CartItem> cart = (List<CartItem>) request.getSession().getAttribute("cart");
            Product product = productDao.GetProductById(productId);
            if (cart == null) {
                cart = new ArrayList<>();
            }
            cart.add(new CartItem(product,1));
            request.getSession().setAttribute("cart", cart);
        } catch (Exception ex) {
            throw new CommandException("Cart item add exception");
        }

        return JSPNameList.MAIN_PAGE;
    }
}
