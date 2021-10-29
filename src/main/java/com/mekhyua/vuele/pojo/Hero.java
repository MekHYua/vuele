package com.mekhyua.vuele.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * hero
 * @author 
 */
@Data
public class Hero implements Serializable {
    private Integer id;

    private String username;

    private String addr;

    private String gender;

    private String info;

    private String password;

    private Integer code;

    private static final long serialVersionUID = 1L;
}