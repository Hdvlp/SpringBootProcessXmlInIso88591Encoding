package com.processiso88591.demo.config;

public class UrlConfig {
    private static final String URL = "http://127.0.0.1:8080/api/iso88591";
    private UrlConfig(){}

    public static String getUrl(){
        return URL;
    }
}
