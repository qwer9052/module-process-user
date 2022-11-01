package com.module.process.service;

import com.module.domain.user.entity.TbUser;
import com.module.domain.user.entityrepo.EUserRepo;
import com.module.domain.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepo userRepo;

    //private final UserRepo userRepo;
    //private final EUserRepo eUserRepo;

    public void user(){

        //eUserRepo.save(new TbUser());
        userRepo.user();
    }
}
