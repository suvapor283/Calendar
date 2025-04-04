package com.korea.calendar;

import com.korea.calendar.domain.diary.service.DiaryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class CalendarApplicationTests {

    @Autowired
    private DiaryService diaryService;

    @Test
    void testJpa() {
        for (int i = 1; i <= 200; i++) {
            String subject = String.format("테스트 데이터 입니다:[%03d]", i);
            String content = "내용 무";
            LocalDate date = LocalDate.parse("2025-04-01");
            this.diaryService.create(subject, content, date);
        }
    }
}