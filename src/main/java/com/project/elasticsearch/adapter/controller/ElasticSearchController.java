package com.project.elasticsearch.adapter.controller;

import com.project.elasticsearch.domain.MemberDocument;
import com.project.elasticsearch.service.ElasticSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/elastic-search")
public class ElasticSearchController {

    private final ElasticSearchService elasticSearchService;

    @GetMapping("/member")
    public MemberDocument findMemberByName(@RequestParam String name){
        return elasticSearchService.findMemberByName(name);
    }
}
