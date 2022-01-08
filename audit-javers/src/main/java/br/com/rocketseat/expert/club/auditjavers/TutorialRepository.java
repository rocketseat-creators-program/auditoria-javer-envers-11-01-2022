package dock.tech.poc.test.demo;

import java.util.List;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    List<Tutorial> findByPublished(boolean published);

    @CircuitBreaker(name = "backendA")
    @Retry(name = "backendA")
    List<Tutorial> findByTitleContaining(String title);
}