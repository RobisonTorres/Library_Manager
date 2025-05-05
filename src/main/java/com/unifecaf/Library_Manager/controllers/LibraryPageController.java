package com.unifecaf.Library_Manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryPageController {

    @GetMapping("/home")
    public String renderHomePage() {

        return "homepage";
    }
}
