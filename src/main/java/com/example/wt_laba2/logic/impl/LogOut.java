package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.JSPNameList;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.bean.SessionAtributes;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.logic.ICommand;
import com.example.wt_laba2.logic.JSPName;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class LogOut implements ICommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        try{
            ProductDao product = DAOFactory.getFactory().getProductDao();
            List<Product> products = product.GetAllProduct();
            request.getSession().invalidate();
           request.setAttribute("products", products);

        }catch (DAOException ex){
            throw new CommandException("LogOut error");
        }
        return JSPNameList.MAIN_PAGE;
    }
}
