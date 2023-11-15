package com.example.wt_laba2.logic;

/**
 * The JSPName enum represents different JSP page names along with their URL patterns.
 * Each enum constant corresponds to a specific JSP page name and its associated URL pattern.
 */
public enum JSPName {
    MAIN_PAGE("/WT_LABA2_war/"),   // Represents the main page with the specified URL pattern.
    ERROR_PAGE("");                // Represents the error page with an empty URL pattern.

    private final String urlPattern;

    /**
     * Constructs a JSPName enum constant with a specified URL pattern.
     *
     * @param urlPattern The URL pattern associated with the JSP page.
     */
    JSPName(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    /**
     * Retrieves the URL pattern associated with the JSP page.
     *
     * @return The URL pattern of the JSP page.
     */
    public String getUrlPattern() {
        return urlPattern;
    }

    /**
     * Retrieves the JSPName enum constant based on the given URI.
     *
     * @param uri The URI to match against URL patterns.
     * @return The matching JSPName enum constant, or null if no match is found.
     */
    public static JSPName fromURI(String uri) {
        for (JSPName mapping : values()) {
            if (mapping.getUrlPattern().equals(uri)) {
                return mapping;
            }
        }
        return null;
    }
}

