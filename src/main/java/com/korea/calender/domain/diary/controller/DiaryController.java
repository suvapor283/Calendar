package com.korea.calender.domain.diary.controller;

import com.korea.calender.domain.diary.entity.Diary;
import com.korea.calender.domain.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/diary")
public class DiaryController {

    private final DiaryService diaryService;

    @GetMapping("/list")
    public String list(Model model) {

        List<Diary> diaryList = diaryService.getList();
        model.addAttribute("diaryList", diaryList);

        return "diary_list";
    }

}