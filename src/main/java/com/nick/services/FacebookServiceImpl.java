package com.nick.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;

public class FacebookServiceImpl implements FacebookService {

    @Autowired
    private FacebookTemplate facebookTemplate;

    @Override
    public User geUser() {
        User profile = facebookTemplate
                .userOperations()
                .getUserProfile();
        return profile;
    }
}
