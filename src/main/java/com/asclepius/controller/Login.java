package com.asclepius.controller;

import com.asclepius.provider.GithubProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class Login {

    @GetMapping("/login")
    public String goIndex(){
        return "login";
    }
}
