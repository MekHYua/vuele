package com.mekhyua.vuele.entity;

import lombok.Data;


@Data
public class Meta {

    public Meta() {
    }

    public Meta(String icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    String icon;

    String title;
}
