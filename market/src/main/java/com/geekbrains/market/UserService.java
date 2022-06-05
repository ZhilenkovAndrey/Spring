package com.geekbrains.market;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserService {
    private User currentUser;

    @PostConstruct
    public void init() {
        this.currentUser = new User();
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
