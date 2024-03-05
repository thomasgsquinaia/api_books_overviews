package com.apilib.domain.book;
public record RequestBook(
        Integer id,
        String name,
        String description,
        String image,
        Boolean active
        ) {

}
