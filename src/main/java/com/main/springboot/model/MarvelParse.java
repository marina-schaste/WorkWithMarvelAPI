package com.main.springboot.model;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MarvelParse {
    String publicKey = "c4b5cc3ec35965fc4ee1cfb4da512fa1";
    String privateKey = "587fbc5b09c8b6757d5ffe8edd9237bdddb03783";
    public String getHeroes(int limit) throws NoSuchAlgorithmException {
        ConnectUrl con = new ConnectUrl();
        String url = this.getDataByUrl("http://gateway.marvel.com/v1/public/characters", limit);
        String get_result = con.getData(url);

        ParserJ json_parser = new ParserJ();
        get_result = json_parser.getValByProp(get_result, "data");
        get_result = json_parser.getValByProp(get_result, "results");

//        System.out.println(get_result);
        return get_result;
    }
    public String getComics(int limit) throws NoSuchAlgorithmException {//ToDo
        ConnectUrl con = new ConnectUrl();
        String url = this.getDataByUrl("http://gateway.marvel.com/v1/public/comics", limit);
        String get_result = con.getData(url);

        ParserJ json_parser = new ParserJ();
        get_result = json_parser.getValByProp(get_result, "data");
        get_result = json_parser.getValByProp(get_result, "results");

        System.out.println(url);
        System.out.println(get_result);
        return get_result;
    }

        public String getComicsById(int id) throws NoSuchAlgorithmException {//ToDo
        ConnectUrl con = new ConnectUrl();
        String url = this.getDataByUrl("http://gateway.marvel.com/v1/public/comics/"+id, 1);
        String get_result = con.getData(url);

        ParserJ json_parser = new ParserJ();
        get_result = json_parser.getValByProp(get_result, "data");
        get_result = json_parser.getValByProp(get_result, "results");
        get_result = json_parser.getValByProp(get_result, "0");

        return get_result;
    }

    public String getHeroById(int id) throws NoSuchAlgorithmException {
        ConnectUrl con = new ConnectUrl();
        String url = this.getDataByUrl("http://gateway.marvel.com/v1/public/characters/"+id, 1);
        String get_result = con.getData(url);

        ParserJ json_parser = new ParserJ();
        get_result = json_parser.getValByProp(get_result, "data");
        get_result = json_parser.getValByProp(get_result, "results");
        get_result = json_parser.getValByProp(get_result, "0");
        return get_result;
    }

    public String getDataByUrl(String url, int limit) throws NoSuchAlgorithmException {
        long timeStamp = System.currentTimeMillis();
        String stringToHash = timeStamp+privateKey+publicKey;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(stringToHash.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter.printHexBinary(digest).toLowerCase();
        String data = String.format("%s?ts=%d&apikey=%s&hash=%s&limit=%d", url, timeStamp, publicKey, hash, limit);
        return data;
    }
}
