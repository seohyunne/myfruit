package com.myfruit.pms.dto;

public class ItemDto {
    private Integer id;
    private String item;     // html 의 name 과 동일

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
