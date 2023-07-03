package com.project.elasticsearch.domain;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.Id;


@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Document(indexName = "test")
public class MemberDocument {

    @Id
    private String id;
    @Field(name = "name")
    private String name;
    @Field(name = "salary")
    private Integer salary;
    @Field(name = "age")
    private Integer age;

//    private String nickName;
}
