package com.example.crops.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {
    private Long id;

    private String title;

    private String userId;

    private String content;

    private Date createDate;

    private Long cnt;
}
