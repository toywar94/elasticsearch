package com.project.elasticsearch.service.outPort;

import com.project.elasticsearch.domain.MemberDocument;

public interface ElasticSearchRepository {

    MemberDocument findMemberByName(String name);
}
