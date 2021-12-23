package br.com.rocketseat.expert.club.auditjavers.repository;

import br.com.rocketseat.expert.club.auditjavers.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByPublished(boolean published);

    List<Book> findByTitleContaining(String title);
}
