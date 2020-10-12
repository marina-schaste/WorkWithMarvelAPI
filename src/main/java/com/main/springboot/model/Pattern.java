package com.main.springboot.model;

import java.util.ArrayList;

public class Pattern {
    ArrayList<String> pattern = new ArrayList<>();
    public ArrayList<String> patternTable() {
        pattern.add("<table>");
        pattern.add("<tr>");
        pattern.add("<td>");
        pattern.add("</td>");
        pattern.add("</tr>");
        pattern.add("</table>");
        return pattern;
    }
    public ArrayList<String> patternSpecTable(String head) {
        pattern.add("<table class=\"classicTable\">" + head);
//                "<thead><tr><td>id</td><td>name</td><td>image</td><td>description</td><td>comics</td></tr></thead>");
        pattern.add("<tr>");
        pattern.add("<td>");
        pattern.add("</td>");
        pattern.add("</tr>");
        pattern.add("</table>");
        return pattern;
    }
    public ArrayList<String> patternComma() {
        ArrayList<String> pattern = new ArrayList<>();
        pattern.add("");
        pattern.add("");
        pattern.add("");
        pattern.add(",");
        pattern.add("");
        pattern.add("");
        return pattern;
    }
}
