package com.korea.calendar.domain.auth.controller;

import com.korea.calendar.domain.auth.form.UserCreateForm;
import com.korea.calendar.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm) {

        return "pages/auth/signup_form";
    }

    @PostMapping("/signup")
    public String Signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "pages/auth/signup_form";
        }

        if (!userCreateForm.getPassword().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", "패스워드가 일치하지 않습니다.");

            return "pages/auth/signup_form";
        }

        try {
            userService.create(userCreateForm.getUsername(), userCreateForm.getPassword(), userCreateForm.getEmail());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");

            return "pages/auth/signup_form";

        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());

            return "pages/auth/signup_form";
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {

        return "pages/auth/login_form";
    }
}