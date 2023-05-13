package com.project.elasticsearch.adapter.controller;

import com.project.elasticsearch.domain.MemberDocument;
import com.project.elasticsearch.service.ElasticSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/elastic-search")
public class ElasticSearchController {

    private final ElasticSearchService elasticSearchService;

    @GetMapping("/term")
    public List<MemberDocument> findMemberByName(@RequestParam String name) throws IOException {
        return elasticSearchService.findMemberByName(name);
    }

    @GetMapping("/match-all")
    public List<MemberDocument> findMatchAll() throws IOException {
        return elasticSearchService.findMatchAll();
    }

    @GetMapping("/match")
    public List<MemberDocument> findMatchByName(@RequestParam String name) throws IOException {
        return elasticSearchService.findMatchByName(name);
    }

    @GetMapping("/multi-match")
    public SearchResponse findMultiMatchByName(@RequestParam String name) throws IOException {
        return elasticSearchService.findMultiMatchByName(name);
    }

    @GetMapping("/must")
    public List<MemberDocument> findMust(@RequestParam String name,
                                   @RequestParam Integer age,
                                   @RequestParam Integer salary) throws IOException {
        return elasticSearchService.findMust(name, age, salary);
    }

    @GetMapping("/wild-card")
    public List<MemberDocument> findWildCard(@RequestParam String name) throws IOException {
        return elasticSearchService.findWildCard(name);
    }

}
