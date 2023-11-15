package com.example.wt_laba2.logic;

import com.example.wt_laba2.Jsp.impl.ErrorPage;
import com.example.wt_laba2.Jsp.impl.MainPage;

import java.util.HashMap;
import java.util.Map;

/**
 * The JSPHelper class manages the mapping of JSP pages to their corresponding names.
 * It provides methods to retrieve specific JSP pages based on their names or mappings.
 */
public class JSPHelper {

    /**
     * Singleton instance of the JSPHelper class.
     */
    private static final JSPHelper jspHelper = new JSPHelper();

    /**
     * Map containing JSPName enum as keys and JSPPAge implementations as values.
     * This map stores the available JSP pages and their associated implementations.
     */
    private Map<JSPName, JSPPAge> pages = new HashMap<>();

    /**
     * Constructs a JSPHelper instance and initializes available JSP pages.
     * The constructor populates the pages map with predefined JSP pages.
     */
    public JSPHelper() {
        // Initializing predefined JSP pages
        pages.put(JSPName.MAIN_PAGE, new MainPage());
        pages.put(JSPName.ERROR_PAGE, new ErrorPage());
    }

    /**
     * Retrieves the singleton instance of the JSPHelper class.
     *
     * @return The singleton instance of JSPHelper.
     */
    public static JSPHelper getJspHelper() {
        return jspHelper;
    }

    /**
     * Retrieves the JSPPAge implementation associated with the given mapping.
     *
     * @param mapping The mapping or name of the JSP page.
     * @return The JSPPAge implementation corresponding to the mapping.
     *         Returns the error page if the mapping is invalid or not found.
     */
    public JSPPAge getPage(String mapping) {
        JSPName pageName = null;
        JSPPAge page = null;

        try {
            pageName = JSPName.fromURI(mapping);
            page = pages.get(pageName);
        } catch (IllegalArgumentException | NullPointerException e) {
            // Log the exception or invalid mapping
            page = pages.get(JSPName.ERROR_PAGE);
        }

        return page;
    }
}



