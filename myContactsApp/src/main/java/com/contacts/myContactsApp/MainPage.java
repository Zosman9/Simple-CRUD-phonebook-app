package com.contacts.myContactsApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPage {

    @GetMapping("")
    public String showHomePage() {
        return "index";
    }

}
