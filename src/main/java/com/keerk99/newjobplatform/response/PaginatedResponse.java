package com.keerk99.newjobplatform.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class PaginatedResponse <T>{
    private Integer totalPages;
    private Long totalElements;
    private Integer size;
    private Integer number;
    private Boolean hasNext;
    private Boolean hasPrevious;
    private String nextPageUrl;
    private String previousPageUrl;
    private List<T> content;

    public PaginatedResponse(Page<T> page, String baseUrl) {
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.size = page.getSize();
        this.number = page.getNumber();
        this.hasNext = page.hasNext();
        this.hasPrevious = page.hasPrevious();
        this.nextPageUrl = hasNext ? baseUrl + "?page=" + (number + 1) : null;
        this.previousPageUrl = hasPrevious ? baseUrl + "?page=" + (number - 1) : null;
        this.content = page.getContent();
    }
}
