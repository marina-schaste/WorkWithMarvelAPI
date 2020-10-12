package com.main.springboot.controller;

import com.main.springboot.model.HeroModel;
import com.main.springboot.model.MarvelParse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.NoSuchAlgorithmException;

@Controller
public class HeroController {
    @GetMapping("/hero")
    public String all_heroes(Model model, @RequestParam(value="id", required=true) int id_hero) throws NoSuchAlgorithmException {
        MarvelParse m_parse = new MarvelParse();
        String hero_json = m_parse.getHeroById(id_hero);
        HeroModel heroM = new HeroModel();
        model.addAttribute("result", heroM.printCard(hero_json));
        model.addAttribute("title", "Hero");
        return "main";
    }
}
