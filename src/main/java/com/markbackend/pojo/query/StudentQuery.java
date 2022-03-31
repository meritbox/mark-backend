package com.markbackend.pojo.query;

import lombok.Data;

@Data
public class StudentQuery {
    private Integer pageNum = 1;
    private Integer pageSize = 2;
    private String name;
}
