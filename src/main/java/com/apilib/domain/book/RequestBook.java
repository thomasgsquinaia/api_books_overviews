package com.apilib.domain.book;

import jakarta.validation.constraints.NotBlank;

public record RequestBook(
        Integer id,
        String name,
        String description,
        String image,
        Boolean active
        ) {

}
