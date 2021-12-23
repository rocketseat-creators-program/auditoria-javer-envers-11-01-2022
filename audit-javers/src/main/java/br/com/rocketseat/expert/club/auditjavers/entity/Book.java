package br.com.rocketseat.expert.club.auditjavers.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;

    @Override
    public String toString() {
        return String.format("Book(id=%s title=%s description=%s published=%s)", id, title, description, published);
    }
}
