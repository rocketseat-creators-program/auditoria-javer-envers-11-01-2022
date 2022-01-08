package br.com.rocketseat.expert.club.auditenvers;

import org.hibernate.envers.RevisionListener;

public class UserRevisionListener implements RevisionListener {

    public final static String USERNAME = "Rocketseat";

    @Override
    public void newRevision(Object revisionEntity) {
        UserRevEntity exampleRevEntity = (UserRevEntity) revisionEntity;
        exampleRevEntity.setUsername(USERNAME);
    }
}