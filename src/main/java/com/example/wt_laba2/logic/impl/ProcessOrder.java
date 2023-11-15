package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.bean.JSPNameList;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.dao.OrderDao;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class ProcessOrder implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        OrderDao orderDao = null;
        Dictionary<Integer,Integer> amount = null;
        try {

            String address = request.getParameter("address");
            orderDao = DAOFactory.getFactory().getOrderDao();
            List<CartItem> cart = (ArrayList<CartItem>)request.getSession().getAttribute("cart");

            for (CartItem object : cart) {
                amount.put(
                        object.getProduct().getId(),
                        Integer.parseInt(request.getParameter("amount_" + object.getProduct().getId())));
            }
            orderDao.CreateOrder(address, cart, amount);
            request.getSession().removeAttribute("cart");
        }catch (DAOException ex){
            throw new CommandException("Can't get XmlDao",ex);
        }
        return JSPNameList.MAIN_PAGE;
    }
}
