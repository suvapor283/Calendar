package com.korea.calender.domain.diary.controller;

import com.korea.calender.domain.diary.entity.Diary;
import com.korea.calender.domain.diary.form.DiaryForm;
import com.korea.calender.domain.diary.service.DiaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

        return "diary/diary_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {

        Diary diary = this.diaryService.getDiary(id);
        model.addAttribute("diary", diary);

        return "diary/diary_detail";
    }

    @GetMapping("/create")
    public String create(DiaryForm diaryForm) {

        return "diary/diary_form";
    }

    @PostMapping("create")
    public String create(@Valid DiaryForm diaryForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "diary/diary_form";
        }

        this.diaryService.create(diaryForm.getSubject(), diaryForm.getContent(), diaryForm.getSelectedDate());
        return "redirect:/diary/list";
    }
}