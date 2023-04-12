package com.project.elasticsearch.service;


import com.project.elasticsearch.domain.MemberDocument;
import com.project.elasticsearch.service.outPort.ElasticSearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ElasticSearchService {

    private final ElasticSearchRepository elasticSearchRepo;

    public MemberDocument findMemberByName(String name){
        return elasticSearchRepo.findMemberByName(name);
    }
}
