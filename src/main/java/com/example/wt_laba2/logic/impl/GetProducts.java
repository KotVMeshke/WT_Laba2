package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.bean.SessionAtributes;
import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.dao.UserDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetProducts implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        List<Product> list = null;
        ProductDao productDao = null;
        String category = null;
        try {
            category = request.getParameter("category");
            productDao = DAOFactory.getFactory().getProductDao();
           if (category == null || category == ""){
               list = productDao.GetAllProduct();
           }else {
               list = productDao.GetProductListByCat(category);
           }
//           List<CartItem> cart = (List<CartItem>) request.getSession().getAttribute("cart");
//            for (CartItem object : cart) {
//                if (list.contains(object.getProduct().getId())){
//                    for (Product prod : list) {
//                        if (object.getProduct().getId() == prod.getId()){
//                            prod.inCart = true;
//                        }
//                    }
//                }
//            }

            request.setAttribute("products", list);

        }catch (DAOException ex){
            throw new CommandException("Can't get XmlDao",ex);
        }
        return "index.jsp";
    }
}
