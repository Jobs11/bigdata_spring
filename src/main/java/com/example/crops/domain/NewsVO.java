package com.example.crops.domain;

import lombok.Data;

@Data
public class NewsVO {
    private String title;
    private String link;
    private String imgurl;
    private String description;
    private String newspaper;
    private String pubDate;
}
