package com.project.elasticsearch.adapter.infrastructure;

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
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ElasticSearchRepoImpl implements ElasticSearchRepository {

    private final WebClientConfig webClientConfig;
    private final ElasticSearchConfig elasticSearchConfig;

    @Override
    public MemberDocument findMemberByName(String name) {
        log.info("hello member");
        //index
        SearchRequest searchRequest = new SearchRequest("test");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("name", name));
        searchRequest.source(searchSourceBuilder);

        try {
            SearchResponse search = elasticSearchConfig.elasticsearchClient().search(searchRequest, RequestOptions.DEFAULT);
            log.info("search : {}", search);
            log.info("search.getHits() 1 : {}", search.getHits().getTotalHits().value);
            log.info("search.getHits() 2 : {}", search.getHits().getAt(0).getSourceAsMap());
            log.info("search.getHits() 3 : {}", search.getHits().getAt(0).getSourceAsString());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return new MemberDocument( "test", 10);
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
