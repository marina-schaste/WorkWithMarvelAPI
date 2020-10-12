package com.main.springboot.model;

import java.util.ArrayList;

public class ComicsModel extends Pattern {
    public String printSpecTable(String comics_json) {
        return printByPattern(comics_json, patternSpecTable( "<thead><tr><td>id</td><td>name</td><td>image</td><td>description</td><td>stories</td></tr></thead>"));
    }
    public String printTable(String comics_json) {
        return printByPattern(comics_json,patternTable());
    }
    public String printByPattern(String string_json, ArrayList<String> pattern) {
        if (string_json.length()==0) {
            return "";
        }
        String output = "";
        if (pattern.size() != 6) {
            pattern.clear();
            pattern = patternTable();
        }
        ParserJ parser = new ParserJ();
        output += pattern.get(0);
        int k=0;
        while (parser.getValByProp(string_json, Integer.toString(k)).length()>0)
        {
            output += pattern.get(1);
            String hero=parser.getValByProp(string_json, Integer.toString(k));

            output += pattern.get(2);
            String id_hero = parser.getValByProp(hero, "id");
            output += id_hero;
            output += pattern.get(3);

            output += pattern.get(2);
            output += "<a href=\"./comics_id?id="+id_hero+"\" target=\"_blank\">"+parser.getValByProp(hero, "title")+"</a>";
            output += pattern.get(3);

            output += pattern.get(2);
            String thumbnail_hero = parser.getValByProp(hero, "thumbnail");
            output += "<img alt=\"hero_img\" class=\"img_hero\" src=\""+parser.getValByProp(thumbnail_hero, "path")+"."+parser.getValByProp(thumbnail_hero, "extension") +"\">";
            output += pattern.get(3);

            output += pattern.get(2);
            output += parser.getValByProp(hero, "description");
            output += pattern.get(3);

            output += pattern.get(2);
            ItemsModel items = new ItemsModel();
            output += items.printComma(parser.getValByProp(hero, "stories"));
            output += pattern.get(3);

            k++;
            output += pattern.get(4);
        }
        output += pattern.get(5);
        return output;
    }
}
