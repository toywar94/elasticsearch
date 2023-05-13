package com.project.elasticsearch.domain;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;


@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Document(indexName = "member")
public class MemberDocument {

    private String name;
    private Integer salary;
    private Integer age;

//    private String nickName;
}
