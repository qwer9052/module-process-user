package com.module.process.user;

import com.module.domain.user.model.TbUserDto;
import com.module.domain.user.rest.UserRest;
import com.module.process.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProcess implements UserRest {

    @Autowired
    UserService userService;

    @Override
    public void user() {

        System.out.println("asdadasdad");
        userService.user();

    }

    @Override
    public void createUser(TbUserDto tbUserDto) {
        System.out.println("post user");
    }
}
