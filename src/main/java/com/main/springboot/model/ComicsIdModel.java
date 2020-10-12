package com.main.springboot.model;

import java.util.ArrayList;

public class ComicsIdModel extends Pattern{
    public String printCard(String hero) {
        if (hero.length()==0) {
            return "";
        }
        String output = "";

        ParserJ parser = new ParserJ();


        output += "<div class=\"card\">";
        output += "<div class=\"card_img\">";
        String thumbnail_hero = parser.getValByProp(hero, "thumbnail");
        output += "<img alt=\"hero_img\" class=\"card_img_hero\" src=\""+parser.getValByProp(thumbnail_hero, "path")+"."+parser.getValByProp(thumbnail_hero, "extension") +"\">";
        output += "</div>";//class card_img

        output += "<div class=\"card_desc\">";
        output += "<h1>";
        output += parser.getValByProp(hero, "title");
        output += " - ";
        output += parser.getValByProp(hero, "id");
        output += "</h1>";



        output += "<p>";
        output += parser.getValByProp(hero, "description");
        output += "</p>";

        ItemsModel items = new ItemsModel();

        output += "<p>Series:<br>";
        output += items.printComma(parser.getValByProp(hero, "series"));
        output += "</p>";

        output += "<p>Stories:<br>";
        output += items.printComma(parser.getValByProp(hero, "stories"));
        output += "</p>";

        output += "<p>Events:<br>";
        output += items.printComma(parser.getValByProp(hero, "events"));
        output += "</p>";

        output += "</div>";//class card_desc

        output += "</div>";//class card
        return output;
    }
}
