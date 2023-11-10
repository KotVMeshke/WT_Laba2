package com.example.wt_laba2.Jsp.impl;

import com.example.wt_laba2.bean.JSPNameList;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.logic.JSPName;
import com.example.wt_laba2.logic.JSPPAge;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class MainPage implements JSPPAge {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        List<Product> list = null;
        String result = "";
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
            result = JSPNameList.MAIN_PAGE;
            request.setAttribute("products", list);
            request.getSession().setAttribute("products", list);

        }catch (DAOException ex){
            throw new CommandException("Page Error",ex);
        }
        return result;
    }
}
