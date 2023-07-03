package com.project.elasticsearch.adapter.infrastructure;

import com.project.elasticsearch.domain.MemberDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepo extends ElasticsearchRepository<MemberDocument, String> {

    List<MemberDocument> findByName(String name);

}
