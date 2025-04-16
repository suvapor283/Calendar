package com.korea.calendar.domain.diary.service;

import com.korea.calendar.domain.diary.entity.Diary;
import com.korea.calendar.domain.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public Page<Diary> getList(int page) {

        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "date"));

        return this.diaryRepository.findAll(pageable);
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