package com.example.crops.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class BoardVO {

    private Integer id;

    private String title;

    private String userId;

    private String content;

    private Date createDate;

    private int cnt;


}
