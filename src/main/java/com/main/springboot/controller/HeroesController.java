package com.main.springboot.controller;

import com.main.springboot.model.HeroesModel;
import com.main.springboot.model.MarvelParse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Controller
public class HeroesController {
    @GetMapping("/heroes")
    public String all_heroes(Model model, @RequestParam(value="count", required=false, defaultValue="5") int count) throws IOException, NoSuchAlgorithmException {
        MarvelParse allHeroes = new MarvelParse();
        String heroes_json = allHeroes.getHeroes(count);
        HeroesModel heroesM = new HeroesModel();
        model.addAttribute("result", heroesM.printSpecTable(heroes_json));
        model.addAttribute("title", "Heroes");
        model.addAttribute("link", "heroes");
        model.addAttribute("count", count);
        return "main";
    }
}
