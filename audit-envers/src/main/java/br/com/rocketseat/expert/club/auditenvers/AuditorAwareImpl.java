package br.com.rocketseat.expert.club.auditenvers;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // return Optional.of("Expert Club");
        return Optional.of("Expert Club 2");
    }

}