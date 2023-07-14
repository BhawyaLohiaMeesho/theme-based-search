package com.hacksmiths.themesearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @Autowired
    Handler handler;

    @RequestMapping(value = "/theme-search", method = RequestMethod.POST, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public String fetchCatalogs(Request request)
            throws Exception {
        handler.handle();
       return "SUCCESS";
    }
}

