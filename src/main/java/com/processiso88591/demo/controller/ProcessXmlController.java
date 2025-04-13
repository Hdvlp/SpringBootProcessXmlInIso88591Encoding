package com.processiso88591.demo.controller;

import com.processiso88591.demo.config.UrlConfig;
import com.processiso88591.demo.model.ESProduct;
import com.processiso88591.demo.service.ProcessService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.PrintStream;
import java.util.List;


@RestController
public class ProcessXmlController {

    private final ProcessService processService;

    public ProcessXmlController(ProcessService processService){
        this.processService = processService;
    }

    @GetMapping("/unmarshal/xml")
    public String unmarshalXml() {
       processService.getPrograms(UrlConfig.getUrl());
        List<ESProduct> list = processService.getPrograms(UrlConfig.getUrl()).getEsProducts();

        String tmp = "";
        for (var prod : list){
            try {
                System.setOut(new PrintStream(System.out, false, "ISO-8859-1"));
                System.out.println(prod.getProductType());
                System.out.println(prod.getOriginalTitle());
                tmp = prod.getOriginalTitle();
            } catch (Exception e){}
        }
        return tmp;
    }


}



