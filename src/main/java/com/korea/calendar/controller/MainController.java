package com.korea.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {

        return "_layouts/main"; // 나중에 바꾸기
    }
}