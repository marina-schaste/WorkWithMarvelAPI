package com.main.springboot.controller;

import com.main.springboot.model.ComicsIdModel;
import com.main.springboot.model.MarvelParse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.NoSuchAlgorithmException;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){


        return "home";
    }
}
