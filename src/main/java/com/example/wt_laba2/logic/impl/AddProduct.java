package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.JSPNameList;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.exception.ServiceException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.factory.ServiceFactory;
import com.example.wt_laba2.logic.ICommand;
import com.example.wt_laba2.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * The AddProduct class implements ICommand to handle adding a new product functionality.
 * It retrieves necessary parameters from the HttpServletRequest and adds a new product to the database.
 */
public class AddProduct implements ICommand {

    /**
     * Executes the action to add a new product based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information about the product to be added.
     * @return A String representing the JSP name to navigate after adding the product.
     * @throws CommandException           If an error occurs while executing the add product action.
     * @throws ParserConfigurationException If there's an issue with the parser configuration.
     * @throws IOException                If an I/O exception occurs during execution.
     * @throws DAOException               If there's an issue with the Data Access Object.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        InputStream inputStream = null;
        ProductService productService = null;
        try {
            productService = ServiceFactory.getInstance().getProductService();
            String productName = request.getParameter("productName");
            String productPrice = request.getParameter("productPrice");
            String productCategory = request.getParameter("productCategory");
            Part filePart = request.getPart("productImage");
            if (filePart != null) {
                inputStream = filePart.getInputStream();
            }
            productService.AddProduct(productName,productPrice,productCategory,inputStream);

        } catch (ServiceException ex) {
            throw new CommandException("Error occurred while adding a product to the database.");
        } catch (ServletException ex) {
            throw new CommandException("Incorrect file format or error during file upload.");
        }

        return JSPNameList.ADMINISTRATOR_PAGE;
    }
}
