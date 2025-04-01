package com.korea.calender.domain.diary.service;

import com.korea.calender.domain.diary.entity.Diary;
import com.korea.calender.domain.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public List<Diary> getList() {

        return diaryRepository.findAll();
    }

    public Diary getDiary(Integer id) {

        Optional<Diary> diaryOptional = this.diaryRepository.findById(id);

        if (diaryOptional.isPresent()) {
            return diaryOptional.get();
        } else {
            throw new RuntimeException("데이터가 존재하지 않습니다.");
        }
    }

    public void create(String subject, String content, LocalDate date) {
        Diary diary = new Diary();
        diary.setSubject(subject);
        diary.setContent(content);
        diary.setDate(date);

        this.diaryRepository.save(diary);
    }
}