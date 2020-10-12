package com.main.springboot.model;

import java.util.ArrayList;

public class ItemsModel extends Pattern {
    public String printTable(String string_json) {
        return printByPattern(string_json, patternTable());
    }
    public String printComma(String string_json) {
        return printByPattern(string_json, patternComma());
    }
    public String printByPattern(String string_json, ArrayList<String> pattern) {
        if (string_json.length()==0) {
            return "";
        }
        String output = "";
        if (pattern.size() != 6) {
            pattern.clear();
            pattern = patternComma();
        }
        ParserJ parser = new ParserJ();
        int m=0;
        output += pattern.get(0);
        string_json = parser.getValByProp(string_json, "items");
        while (parser.getValByProp(string_json, Integer.toString(m)).length()>0)  {
            output += pattern.get(1);
            String string_json_self = parser.getValByProp(string_json, Integer.toString(m));
            String string_name = parser.getValByProp(string_json_self, "name");
            output += pattern.get(2);
            output += string_name;
            output += pattern.get(3);
            output += pattern.get(4);
            m++;
        }
        output += pattern.get(5);
        return output;
    }
}
