package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(value = "/greeting")
    public String sayHello(Model model) {
        model.addAttribute("greeting", "Hello World");

        return "hello";
    }

    // forward request along to jsp
    // different than just returning index.jsp since response is continuing
    // our response object, building onto it (not creating a new request)
    @RequestMapping(value="/index")
    public String index(Model model) {
        return "forward:index.jsp";
    }
}
