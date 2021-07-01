package com.gh.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
public class User implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private Score score;

}
