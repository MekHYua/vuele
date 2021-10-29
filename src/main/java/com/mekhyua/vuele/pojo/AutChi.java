package com.mekhyua.vuele.pojo;

import com.mekhyua.vuele.entity.Meta;
import lombok.Data;


@Data
public class AutChi {

    private String path;
    private String redirect;
    private String component;
    private Meta meta;
    private String name;
}
