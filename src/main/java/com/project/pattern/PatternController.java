package com.project.pattern;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/pattern")
public class PatternController {

    private final PatternService patternService;

    @GetMapping("/strategy")
    public void strategy(){
        patternService.strategy();
    }

    @GetMapping("/observer")
    public void observer(){
        patternService.observer();
    }
}
