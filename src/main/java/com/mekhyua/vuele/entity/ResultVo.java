package com.mekhyua.vuele.entity;

import lombok.Data;

import java.util.List;

@Data
public class ResultVo<T> {

    Integer code;

    String message;

    List<T> data;

    long total;
}
