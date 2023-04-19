package com.project.elasticsearch.domain;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Document(indexName = "member")
public class MemberDocument {

//    @Id
//    private Long id;

    private String name;

    private Integer age;
}
