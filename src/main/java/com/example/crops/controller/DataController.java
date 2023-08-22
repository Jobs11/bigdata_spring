package com.example.crops.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@AllArgsConstructor
@RequestMapping("/data/*")
public class DataController {

    @GetMapping("/kinidata")
    public String kinidata(){
        return "data/kinidata";
    }

    @GetMapping("/whatdata")
    public String whatdata(){
        return "data/whatdata";
    }

    @GetMapping("/test")
    public String testdata(){
        return "data/test";
    }
}
