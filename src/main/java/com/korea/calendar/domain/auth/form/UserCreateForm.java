package com.korea.calendar.domain.auth.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {

    @Size(min = 3, max = 20, message = "아이디는 크기가 3에서 20 사이여야 합니다.")
    @NotEmpty(message = "사용자 ID는 필수 항목입니다.")
    private String username;

    @Size(min = 8, max = 30, message = "비밀번호는 크기가 8에서 30 사이여야 합니다.")
    @NotEmpty(message = "비밀번호는 필수 항목입니다.")
    private String password;

    @NotEmpty(message = "비밀번호 확인은 필수 항목입니다.")
    private String password2;

    @NotEmpty(message = "이메일은 필수 항목입니다.")
    @Email
    private String email;
}