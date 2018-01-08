package com.demo.chapter2.model;

import lombok.Data;

/**
 * Created by dell
 * at 2018/1/8
 */
@Data
public class Customer {
    private Long id;
    private String name;
    private String contact;
    private String telephone;
    private String email;
    private String remark;
}
