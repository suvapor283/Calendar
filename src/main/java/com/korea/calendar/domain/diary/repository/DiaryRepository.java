package com.korea.calendar.domain.diary.repository;

import com.korea.calendar.domain.diary.entity.Diary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Integer> {

    Page<Diary> findAll(Pageable pageable);
}