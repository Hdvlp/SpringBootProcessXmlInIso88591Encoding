package com.processiso88591.demo.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "programs")
public class Programs {

    private List<ESProduct> esProducts;

    @XmlElement(name = "ES_PRODUCT")
    public List<ESProduct> getEsProducts() {
        return esProducts;
    }

    public void setEsProducts(List<ESProduct> esProducts) {
        this.esProducts = esProducts;
    }


}