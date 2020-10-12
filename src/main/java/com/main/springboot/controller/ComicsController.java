package com.main.springboot.controller;

//import com.main.springboot.model.HeroesModel;
import com.main.springboot.model.ComicsModel;
import com.main.springboot.model.MarvelParse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Controller
public class ComicsController {
    @GetMapping("/comics")
    public String comics(Model model, @RequestParam(value="count", required=false, defaultValue="5") int count) throws IOException, NoSuchAlgorithmException {
        MarvelParse allComics = new MarvelParse();
        String comics_json = allComics.getComics(count);
        ComicsModel comicsM = new ComicsModel();
        model.addAttribute("result", comicsM.printSpecTable(comics_json));
        model.addAttribute("title", "Comics");
        model.addAttribute("link", "comics");
        model.addAttribute("count", count);
        return "main";
    }
}