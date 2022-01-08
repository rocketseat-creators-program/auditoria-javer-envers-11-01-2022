package dock.tech.poc.test.demo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TutorialService {

    private final TutorialRepository tutorialRepository;

    @CircuitBreaker(name = "backendB")
    @Retry(name = "backendB")
    public List<Tutorial> getAllTutorials(String title){
        List<Tutorial> tutorials = new ArrayList<Tutorial>();
        try {
            System.out.println("Entrei!");
            if (title == null)
                tutorialRepository.findAll().forEach(tutorials::add);
            else
                tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return tutorials;
    }

    public Optional<Tutorial> getById(Long id){
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
        return tutorialData;
    }

    public Tutorial save(Tutorial tutorial){
        Tutorial _tutorial = tutorialRepository
                .save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
        return _tutorial;
    }

    public void deleteById(long id) {
        tutorialRepository.deleteById(id);
    }

    public List<Tutorial> findByPublished() {
        List<Tutorial> tutorials = tutorialRepository.findByPublished(true);
        return tutorials;
    }
}
