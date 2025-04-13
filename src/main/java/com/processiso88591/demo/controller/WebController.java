package com.processiso88591.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/")
    public String index() {
        return String.format("<div><a href=\"%s\">Provide data in ISO 8859-1</a> </div><div><a href=\"%s\">Fetch file</a></div><div><a href=\"%s\">Fetch data and unmarshal XML</a> </div>",
            "/api/iso88591",
            "/fetch/file",
            "/unmarshal/xml");
    }
}
