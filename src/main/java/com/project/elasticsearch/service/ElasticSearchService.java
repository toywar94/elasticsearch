package com.project.elasticsearch.service;


import com.project.elasticsearch.domain.MemberDocument;
import com.project.elasticsearch.service.outPort.ElasticSearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ElasticSearchService {

    private final ElasticSearchRepository elasticSearchRepo;

    public List<MemberDocument> findMemberByName(String name) throws IOException {
        return elasticSearchRepo.findMemberByName(name);
    }

    public List<MemberDocument> findMatchAll() throws IOException {
        return elasticSearchRepo.findMatchAll();
    }

    public List<MemberDocument> findMatchByName(String name) throws IOException {
        return elasticSearchRepo.findMatchByName(name);
    }

    public SearchResponse findMultiMatchByName(String name) throws IOException {
        return elasticSearchRepo.findMultiMatchByName(name);
    }

    public List<MemberDocument> findMust(String name, Integer age, Integer salary) throws IOException {
        return elasticSearchRepo.findMust(name, age, salary);
    }

    public List<MemberDocument> findWildCard(String name) throws IOException {
        return elasticSearchRepo.findWildCard(name);
    }

}
