package com.apilib.domain.book;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "book")
@Entity(name = "book")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String image;
    private Boolean active;

    public Book(RequestBook requestBook) {
        this.name = requestBook.name();
        this.name = requestBook.name();
        this.name = requestBook.name();
    }
}
