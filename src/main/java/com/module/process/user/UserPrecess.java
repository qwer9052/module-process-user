package com.module.process.user;

import com.module.domain.user.rest.UserRest;
import com.module.process.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPrecess implements UserRest {

    @Autowired
    UserService userService;

    @Override
    public void user() {

        System.out.println("asdadasdad");
        userService.user();

    }
}
