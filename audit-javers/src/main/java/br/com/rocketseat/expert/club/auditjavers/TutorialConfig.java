package br.com.rocketseat.expert.club.auditjavers;

import org.javers.common.collections.Maps;
import org.javers.spring.auditable.AuthorProvider;
import org.javers.spring.auditable.CommitPropertiesProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Map;

@Configuration
public class TutorialConfig {

    @Bean
    public AuthorProvider authorProvider() {
        return () -> "Expert Club";
    }

    @Bean
    public CommitPropertiesProvider commitPropertiesProvider() {
        return new CommitPropertiesProvider() {
            @Override
            public Map<String, String> provideForCommittedObject(Object domainObject) {
                if (domainObject instanceof Tutorial) {
                    return Maps.of("tutorial-id", ((Tutorial)domainObject).getId() + "");
                }
                return Collections.emptyMap();
            }
        };
    }

}
