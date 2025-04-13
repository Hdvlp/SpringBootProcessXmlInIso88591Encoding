package com.processiso88591.demo.config;

import com.processiso88591.demo.model.Programs;
import com.processiso88591.demo.utils.CombinedXmlConverter;

import jakarta.xml.bind.JAXBException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() throws JAXBException {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setMessageConverters(Arrays.asList(
                new CombinedXmlConverter<>(Programs.class)
        ));

        return restTemplate;
    }
}