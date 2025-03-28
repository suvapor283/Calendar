package com.korea.calender.domain.diary.service;

import com.korea.calender.domain.diary.entity.Diary;
import com.korea.calender.domain.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public List<Diary> getList() {

        return diaryRepository.findAll();
    }
}