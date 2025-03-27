package com.korea.calender.domain.diary.controller;

import com.korea.calender.domain.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;
}