package com.processiso88591.demo.service;

import com.processiso88591.demo.model.Programs;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProcessService {
    private final RestTemplate restTemplate;

    public ProcessService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Programs getPrograms(String url) {
        return restTemplate.getForObject(url, Programs.class);
    }
}
