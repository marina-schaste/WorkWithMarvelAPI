package com.main.springboot.controller;

import com.main.springboot.model.ComicsIdModel;
import com.main.springboot.model.ComicsModel;
import com.main.springboot.model.HeroModel;
import com.main.springboot.model.MarvelParse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.NoSuchAlgorithmException;

@Controller
public class ComicsIdController {
    @GetMapping("/comics_id")
    public String all_heroes(Model model, @RequestParam(value="id", required=true) int id_comics) throws NoSuchAlgorithmException {

        MarvelParse m_parse = new MarvelParse();
        String comics_json = m_parse.getComicsById(id_comics);
        ComicsIdModel comicsM = new ComicsIdModel();
        model.addAttribute("result", comicsM.printCard(comics_json));
        model.addAttribute("title", "Comics card");
        return "main";
    }
}
