package com.ltweb_servlet_ecommerce.model;

public class SizeModel extends AbstractModel<SizeModel>{
    private String name;

    public String getSizeName() {
        return name;
    }

    public void setSizeName(String sizeName) {
        this.name = sizeName;
    }
}
