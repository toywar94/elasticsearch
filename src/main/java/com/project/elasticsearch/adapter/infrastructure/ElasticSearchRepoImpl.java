package com.project.elasticsearch.adapter.infrastructure;

import com.project.elasticsearch.domain.MemberDocument;
import com.project.elasticsearch.service.outPort.ElasticSearchRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Repository;

@Repository
public class ElasticSearchRepoImpl implements ElasticSearchRepository {

    @Override
    public MemberDocument findMemberByName(String name) {
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        ssb.query(QueryBuilders.termQuery("name", name));
        return null;
    }
}
