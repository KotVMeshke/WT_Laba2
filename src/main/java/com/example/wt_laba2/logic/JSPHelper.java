package com.example.wt_laba2.logic;

import com.example.wt_laba2.Jsp.impl.ErrorPage;
import com.example.wt_laba2.Jsp.impl.MainPage;

import java.util.HashMap;
import java.util.Map;

public class JSPHelper {

    private static final JSPHelper jspHelper = new JSPHelper();

    private Map<JSPName, JSPPAge> pages = new HashMap<>();

    public JSPHelper() {
        pages.put(JSPName.MAIN_PAGE, new MainPage());
        pages.put(JSPName.ERROR_PAGE, new ErrorPage());

    }

    public static  JSPHelper getJspHelper() {
        return jspHelper;
    }

    public JSPPAge getPage(String mapping) {
        JSPName pageName = null;
        JSPPAge page = null;

        try {
            pageName = JSPName.fromURI(mapping);
            page = pages.get(pageName);
        } catch (IllegalArgumentException | NullPointerException e) {
            //write log
            page = pages.get(JSPName.ERROR_PAGE);
        }

        return page;
    }
}


