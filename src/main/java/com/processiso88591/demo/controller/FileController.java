package com.processiso88591.demo.controller;

import com.processiso88591.demo.config.UrlConfig;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.PrintStream;
import java.nio.charset.Charset;

@RestController
public class FileController {

    @GetMapping("/fetch/file")
    public String fetchFile(HttpServletResponse response) {
        response.addHeader("Content-type", "application/xml;charset=iso-8859-1");

        RestTemplate restTemplate = new RestTemplate();
        String urlWithISO88591Content = UrlConfig.getUrl();

        // Fetch the file as a byte array
        byte[] responseBytes = restTemplate.getForObject(urlWithISO88591Content, byte[].class);

        // Convert the byte array to a String using ISO-8859-1 encoding
        String fileContentInISO88591 = new String(responseBytes, Charset.forName("ISO-8859-1"));
        String ret = "";
        try {
            System.setOut(new PrintStream(System.out, false, "ISO-8859-1"));
            System.out.println("fileContentInISO88591 : " + fileContentInISO88591);
            ret = fileContentInISO88591;

        }
        catch (Exception e){}
        finally {
            ret = fileContentInISO88591;
        }
        return ret;
    }
}