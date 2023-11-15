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

public class UpdateCart implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {

        try {
            String str = request.getParameter("quantity");
            String id = request.getParameter("productId");
            List<CartItem> cart = (ArrayList<CartItem>)request.getSession().getAttribute("cart");
            for (CartItem object : cart) {
                if (object.getProduct().getId() == Integer.parseInt(id)){
                    object.amount = Integer.parseInt(str);
                }
            }
            request.getSession().removeAttribute("cart");
            request.getSession().setAttribute("cart",cart);

        }catch (Exception ex){
            throw new CommandException("Can't get XmlDao",ex);
        }
        return JSPNameList.CART_PAGE;
    }
}
