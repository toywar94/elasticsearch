package com.project.elasticsearch.service.outPort;

import com.project.elasticsearch.domain.MemberDocument;
import org.elasticsearch.action.search.SearchResponse;

import java.io.IOException;
import java.util.List;

public interface ElasticSearchRepository {

    List<MemberDocument> findMemberByName(String name) throws IOException;

    List<MemberDocument> findMatchAll() throws IOException;

    List<MemberDocument> findMatchByName(String name) throws IOException;

    SearchResponse findMultiMatchByName(String name) throws IOException;

    List<MemberDocument> findMust(String name, Integer age, Integer salary) throws IOException;

    List<MemberDocument> findWildCard(String name) throws IOException;
}
