package com.j21.bookstore.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Author implements IBaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private int yearOfBirth;
    private String placeOfBirth;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "author")
    private Set<Book> books;

    // [ TO_STRING_OBJ, TO_STRING_OBJ ... ]
}
