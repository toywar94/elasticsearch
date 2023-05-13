package com.project.elasticsearch.adapter.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.common.config.WebClientConfig;
import com.project.elasticsearch.config.ElasticSearchConfig;
import com.project.elasticsearch.domain.MemberDocument;
import com.project.elasticsearch.service.outPort.ElasticSearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ElasticSearchRepoImpl implements ElasticSearchRepository {

    private final WebClientConfig webClientConfig;
    private final ElasticSearchConfig elasticSearchConfig;

    private static final String TEST_INDEX = "test";
    private static final String TEST2_INDEX = "test2";
    private static final String TYPE = "member";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<MemberDocument> findMemberByName(String name) throws IOException {
        SearchRequest searchRequest = createSearchRequest(TEST_INDEX.toString());
        SearchSourceBuilder searchSourceBuilder = createSearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("name", name));
        searchRequest.source(searchSourceBuilder);

        SearchResponse search = elasticSearchConfig.elasticsearchClient().search(searchRequest, RequestOptions.DEFAULT);
        return mapHits(search.getHits(), MemberDocument.class);

    }

    @Override
    public List<MemberDocument> findMatchAll() throws IOException {
        SearchRequest searchRequest = createSearchRequest(TEST_INDEX.toString());
        SearchSourceBuilder searchSourceBuilder = createSearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);

        SearchResponse search = elasticSearchConfig.elasticsearchClient().search(searchRequest, RequestOptions.DEFAULT);
        return mapHits(search.getHits(), MemberDocument.class);

    }

    @Override
    public List<MemberDocument> findMatchByName(String name) throws IOException {
        SearchRequest searchRequest = createSearchRequest(TEST_INDEX.toString());
        SearchSourceBuilder searchSourceBuilder = createSearchSourceBuilder();
        SearchSourceBuilder query = searchSourceBuilder.query(QueryBuilders.matchQuery("name", name));
        searchRequest.source(searchSourceBuilder);

        log.info("query : {}", query);

        SearchResponse search = elasticSearchConfig.elasticsearchClient().search(searchRequest, RequestOptions.DEFAULT);
        return mapHits(search.getHits(), MemberDocument.class);
    }

    @Override
    public SearchResponse findMultiMatchByName(String name) throws IOException {
        SearchRequest searchRequest = createSearchRequest(TEST2_INDEX.toString());
        SearchSourceBuilder searchSourceBuilder = createSearchSourceBuilder();
        SearchSourceBuilder query = searchSourceBuilder.query(QueryBuilders.multiMatchQuery(name,"name","nickName"));
        searchRequest.source(searchSourceBuilder);

        log.info("query : {}", query);

        return elasticSearchConfig.elasticsearchClient().search(searchRequest, RequestOptions.DEFAULT);
    }

    @Override
    public List<MemberDocument> findMust(String name, Integer age, Integer salary) throws IOException {
        SearchRequest searchRequest = createSearchRequest(TEST_INDEX.toString());
        SearchSourceBuilder searchSourceBuilder = createSearchSourceBuilder();
        SearchSourceBuilder query = searchSourceBuilder.query(QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery("name", name))
                .must(QueryBuilders.termQuery("salary", salary))
                .mustNot(QueryBuilders.matchQuery("age", age))

        );

        log.info("query : {}", query);
        searchRequest.source(searchSourceBuilder);

        SearchResponse search = elasticSearchConfig.elasticsearchClient().search(searchRequest, RequestOptions.DEFAULT);
        return mapHits(search.getHits(), MemberDocument.class);
    }

    @Override
    public List<MemberDocument> findWildCard(String name) throws IOException {
        SearchRequest searchRequest = createSearchRequest(TEST_INDEX.toString());
        SearchSourceBuilder searchSourceBuilder = createSearchSourceBuilder();
        SearchSourceBuilder query = searchSourceBuilder.query(QueryBuilders.wildcardQuery("name", name+"*"));

        log.info("query : {}", query);
        searchRequest.source(searchSourceBuilder);

        SearchResponse search = elasticSearchConfig.elasticsearchClient().search(searchRequest, RequestOptions.DEFAULT);
        return mapHits(search.getHits(), MemberDocument.class);
    }

    private SearchRequest createSearchRequest(String index){
        return new SearchRequest(index);
    }

    private SearchSourceBuilder createSearchSourceBuilder(){
        return new SearchSourceBuilder();
    }

    private static <T> List<T> mapHits(SearchHits hits, Class<T> clazz) {
        return Arrays.stream(hits.getHits())
                .map(hit -> {
                    String source = hit.getSourceAsString();
                    try {
                        return objectMapper.readValue(source, clazz);
                    } catch (IOException e) {
                        log.error("Hit source error", e);
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    //    Mono<String> result = reqElasticSearch();
//        result.subscribe(response -> {
//        log.info("response : {}", response);
//    }, e -> {
//        log.info("error message : {}", e.getMessage());
//    });
    //WebClent를 이용해서 Http 통신해보기.
    private Mono<String> reqElasticSearch(){
        WebClient webClient = webClientConfig.webClient();
        return webClient.get()
                .uri("http://ip:9200/test/member/_search?q=10")
                .retrieve()
                .bodyToMono(String.class);
    }
}
