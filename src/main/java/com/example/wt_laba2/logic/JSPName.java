package com.example.wt_laba2.logic;

public enum JSPName {
    MAIN_PAGE("/WT_LABA2_war/"),
    ERROR_PAGE("");
    private final String urlPattern;
    JSPName(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public static JSPName fromURI(String uri) {
        for (JSPName mapping : values()) {
            if (mapping.getUrlPattern().equals(uri)) {
                return mapping;
            }
        }
        return null;
    }
}
