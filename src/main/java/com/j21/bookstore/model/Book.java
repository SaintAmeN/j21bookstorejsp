package com.j21.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book implements IBaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private int yearPublished;

    @Enumerated(EnumType.STRING)
    private BookType bookType;

    private int pages;

    @ManyToOne
    private Publisher publisher;

    @ManyToOne
    private Author author;
}
