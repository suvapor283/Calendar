package com.korea.calender.domain.diary.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class DiaryForm {

    @NotEmpty(message = "제목을 입력해주세요.")
    @Size(max = 200)
    private String subject;

    @NotEmpty(message = "내용을 입력해주세요.")
    private String content;

    @NotNull(message = "날짜를 선택하세요.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate selectedDate;
}