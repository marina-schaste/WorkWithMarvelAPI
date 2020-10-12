package com.main.springboot.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.*;

public class ParserJ {
    JSONParser parser = new JSONParser();

    public Object jsonToList(String json) throws Exception {
        Object obj = this.parser.parse(json);
        return getItemsType(obj);
    }

    private HashMap<String, Object> getItemsType(Object obj) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (obj instanceof JSONObject)
        {
            JSONObject jo = (JSONObject) obj;
            return getItems(jo, map);
        }
        else if (obj instanceof JSONArray)
        {
            JSONArray jo = (JSONArray) obj;
            return getItems(jo, map);
        }
        return map;
    }

    private HashMap<String, Object> getItems(JSONObject jo, Object objMap) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        for (Object o : jo.keySet()) {
            String key = (String) o;
            Object self = jo.get(key);
            System.out.println(key + " -:- "+ self.toString());
            map.put(key, self.toString());
            getItemsType(self);
        }
        return map;
    }
    private HashMap<String, Object> getItems(JSONArray jo, Object objMap) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        for (int i=0; i < jo.size(); i++) {
            System.out.println(Integer.toString(i) + " -:- " + jo.get(i).toString());
            map.put(Integer.toString(i), jo.get(i).toString());
            getItemsType(jo.get(i));
        }
        return map;
    }

    public String getValByProp(String json, String prop) {
        try {
            Object obj = (new JSONParser()).parse(json);

            if (obj instanceof JSONObject)
            {
                JSONObject jo = (JSONObject) obj;
                return jo.get(prop) == null ? "" : jo.get(prop).toString();
            }
            else if (obj instanceof JSONArray)
            {
                JSONArray jo = (JSONArray) obj;
                int propNum = Integer.parseInt(prop);
                return jo.get(propNum) == null ? "" : jo.get(propNum).toString();
            } else {
                return "";
            }
        } catch (Exception e) {
//            return e.toString();
            return "";
        }
    }
}