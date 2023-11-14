package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.JSPNameList;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.logic.ICommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AddProduct implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        InputStream inputStream = null;
        ProductDao productDao = null;
        try{
            String productName = request.getParameter("productName");
            String productPrice = request.getParameter("productPrice");
            String productCategory = request.getParameter("productCategory");
            Part filePart = request.getPart("productImage");
            if (filePart != null) {
                inputStream = filePart.getInputStream();
            }
            productDao = DAOFactory.getFactory().getProductDao();
            productDao.AddProduct(productName,productPrice,productCategory,inputStream);


        }catch (DAOException ex){
            throw new CommandException("LogOut error");
        }catch (ServletException ex){
            throw new CommandException("Incorrect file");
        }

        return JSPNameList.ADMINISTRATOR_PAGE;
    }
}
