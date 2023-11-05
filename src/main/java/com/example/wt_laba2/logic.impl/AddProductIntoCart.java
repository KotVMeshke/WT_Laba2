package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.bean.SessionAtributes;
import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class AddProductIntoCart implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        ProductDao productDao = null;
        try {
            productDao = DAOFactory.getFactory().getProductDao();
            int productId = Integer.parseInt(request.getParameter("productId"));
            int userId = (int)request.getSession().getAttribute(SessionAtributes.UserId);
            productDao.AddProductIntoCart(productId,userId,1);

        }catch (DAOException ex){
            throw new CommandException("Can't get XmlDao",ex);
        }
        return null;
    }
}
