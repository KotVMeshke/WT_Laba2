package com.example.wt_laba2.logic.impl;

import com.example.wt_laba2.bean.*;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.factory.ServiceFactory;
import com.example.wt_laba2.logic.ICommand;
import com.example.wt_laba2.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The AddProductIntoCart class implements ICommand to handle adding a product to the cart functionality.
 * It retrieves necessary parameters from the HttpServletRequest and adds the selected product to the cart.
 */
public class AddProductIntoCart implements ICommand {

    /**
     * Executes the action to add a product to the cart based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information about the product to be added to the cart.
     * @return A String representing the JSP name to navigate after adding the product to the cart.
     * @throws CommandException           If an error occurs while executing the add to cart action.
     * @throws ParserConfigurationException If there's an issue with the parser configuration.
     * @throws IOException                If an I/O exception occurs during execution.
     * @throws DAOException               If there's an issue with the Data Access Object.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        ProductService productService = null;
        try {
            productService = ServiceFactory.getInstance().getProductService();
            int productId = Integer.parseInt(request.getParameter("productId"));

            List<CartItem> cart = (List<CartItem>) request.getSession().getAttribute("cart");
            Product product = productService.GetProductById(productId);
            if (cart == null) {
                cart = new ArrayList<>();
            }
            cart.add(new CartItem(product, 1));
            request.getSession().setAttribute("cart", cart);
        } catch (Exception ex) {
            throw new CommandException("Error occurred while adding a product to the cart.");
        }

        return JSPNameList.MAIN_PAGE;
    }
}

