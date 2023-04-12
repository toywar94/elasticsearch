package com.project.elasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {

    @Value("${elasticsearch.host}")
    private String elasticSearchHost;

    @Value("${elasticsearch.port}")
    private int elasticSearchPort;

    @Bean(destroyMethod = "close")
    public RestHighLevelClient elasticsearchClient(){
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(elasticSearchHost, elasticSearchPort, "http")
                )
        );
    }
}
