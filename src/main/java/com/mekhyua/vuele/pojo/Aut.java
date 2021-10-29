package com.mekhyua.vuele.pojo;

import com.mekhyua.vuele.entity.Meta;
import lombok.Data;

import java.util.List;

@Data
public class Aut {

    private String path;
    private String redirect;
    private String component;
    private Meta meta;
    private List<AutChi> children;
    private String name;
}
