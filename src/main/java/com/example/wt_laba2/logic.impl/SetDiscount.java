package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.bean.JSPNameList;
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
import java.util.List;

public class SetDiscount implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        ProductDao productDao = null;
        try {
            String address = request.getParameter("address");
            productDao = DAOFactory.getFactory().getProductDao();
            int productId = Integer.parseInt(request.getParameter("discountProductId"));
            if (productId == 0)
                throw new CommandException("Incorrect product id");
            String discount = request.getParameter("discountAmount");
            int discountValue = Integer.parseInt(discount);
            if (discountValue < 0) {
                discountValue = 0;
            }else if (discountValue > 100){
                discountValue = 100;
            }
            productDao.SetDiscount(productId,discountValue );
        }catch (DAOException ex){
            throw new CommandException("Can't get XmlDao",ex);
        };
        return JSPNameList.ADMINISTRATOR_PAGE;
    }
}
