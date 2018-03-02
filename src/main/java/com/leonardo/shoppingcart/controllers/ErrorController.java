package com.leonardo.shoppingcart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController extends SiteController
{
    private static final String viewPrefix = "error/";

    @Override
    protected String getHeaderTitle()
    {
        return "Error";
    }

    @RequestMapping("/403")
    public String accessDenied()
    {
        return viewPrefix+"accessDenied";
    }

    /* Set 404,500 */

}

