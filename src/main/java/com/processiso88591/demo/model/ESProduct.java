package com.processiso88591.demo.model;

import jakarta.xml.bind.annotation.XmlElement;

public class ESProduct {

    private String productType;
    private String productCode;
    private String originalTitle;
    private String externalReference;
    private int imageSequence;
    private String imageType;
    private String imageURN;

    @XmlElement(name = "p_product_type")
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @XmlElement(name = "p_product_productcode")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @XmlElement(name = "p_product_originaltitle")
    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    @XmlElement(name = "prd_external_reference")
    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    @XmlElement(name = "image1Sequence")
    public int getImageSequence() {
        return imageSequence;
    }

    public void setImageSequence(int imageSequence) {
        this.imageSequence = imageSequence;
    }

    @XmlElement(name = "image1Type")
    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @XmlElement(name = "image1URN")
    public String getImageURN() {
        return imageURN;
    }

    public void setImageURN(String imageURN) {
        this.imageURN = imageURN;
    }
}
