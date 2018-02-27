package com.leonardo.shoppingcart.utils;

import javax.servlet.http.HttpServletRequest;

public class WebUtils
{
    private WebUtils() { }

    public static String getURLWithContextPath(HttpServletRequest request)
    {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
    }
}
