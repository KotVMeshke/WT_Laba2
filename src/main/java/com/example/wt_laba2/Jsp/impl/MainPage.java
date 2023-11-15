package com.example.wt_laba2.Jsp.impl;

import com.example.wt_laba2.bean.CartItem;
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

/**
 * Represents the logic for the main page of the application.
 */
public class MainPage implements JSPPAge {

    /**
     * Executes the logic related to displaying the main page.
     * @param request The HttpServletRequest object.
     * @return A String representing the page or resource to redirect or display.
     * @throws CommandException If an error occurs while executing the command.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        List<Product> list = null;
        String result = "";
        ProductDao productDao = null;
        String category = null;
        try {
            category = request.getParameter("category");
            productDao = DAOFactory.getFactory().getProductDao();
            if (category == null || category.isEmpty()){
                list = productDao.GetAllProduct();
            } else {
                list = productDao.GetProductListByCat(category);
            }

            // The commented code appears to manage cart functionality
            // Uncomment and modify as needed for cart-related logic

            result = JSPNameList.MAIN_PAGE;
            request.setAttribute("products", list);
            request.getSession().setAttribute("products", list);

        } catch (DAOException ex){
            throw new CommandException("Page Error", ex);
        }
        return result;
    }
}
