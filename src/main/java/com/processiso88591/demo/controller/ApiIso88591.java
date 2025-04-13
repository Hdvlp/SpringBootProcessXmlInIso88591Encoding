package com.processiso88591.demo.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiIso88591 {

    @GetMapping("/api/iso88591")
    public String getXml(HttpServletResponse response) {
        response.addHeader("Content-type", "application/xml;charset=iso-8859-1");

        String ret = """
            <?xml version="1.0"?>
                <programs>
                    <ES_PRODUCT>
                        <p_product_type>Episode</p_product_type>
                        <p_product_productcode>123</p_product_productcode>
                        <p_product_originaltitle>Bue, pil, økser og stædighed</p_product_originaltitle>
                        <prd_external_reference>4714857215527</prd_external_reference>
                        <image1Sequence>0</image1Sequence>
                        <image1Type>Standard</image1Type>
                        <image1URN>https://foo.bar</image1URN>
                    </ES_PRODUCT>
                </programs>
""";

        return ret.trim();

    }
}
