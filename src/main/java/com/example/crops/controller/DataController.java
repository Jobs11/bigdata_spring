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

    @GetMapping("/graph_data")
    public String graphdata(){
        return "data/graph_data";
    }

    @GetMapping("/area_data")
    public String areadata(){
        return "data/area_data";
    }

    @GetMapping("/moun_data")
    public String moundata(){
        return "data/moun_data";
    }
}
