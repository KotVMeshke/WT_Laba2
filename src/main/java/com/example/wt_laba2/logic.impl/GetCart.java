package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class GetCart implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        List<CartItem> cart = null;
        ProductDao productDao = null;
        String category = null;
        try {
            productDao = DAOFactory.getFactory().getProductDao();
            cart = productDao.GetProductsFromCart();
            request.setAttribute("cart", cart);

        }catch (DAOException ex){
            throw new CommandException("Can't get XmlDao",ex);
        }
        return "/JSP/Cart.jsp";
    }
}
