package com.module.process.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.module.core.exception.CommonException;
import com.module.domain.user.entity.TbUser;
import com.module.domain.user.entityrepo.EUserRepo;
import com.module.domain.user.model.TbUserDto;
import com.module.domain.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepo userRepo;

    private static final ObjectMapper mapper = new ObjectMapper();

    public TbUserDto findByUserId(Long userId) throws CommonException {
        TbUser tbUser = userRepo.findByUserId(userId).orElseThrow(() -> new CommonException("존재하지 않는 회원 pk입니다."));
        return mapper.convertValue(tbUser, TbUserDto.class);
    }

    public Long signup(TbUserDto tbUserDto) {
        Optional<TbUser> tbUser = userRepo.findByEmail(tbUserDto.getEmail());
        tbUser.ifPresent(user -> {
            throw new CommonException("이미 존재하는 아이디 입니다.");
        });
        return userRepo.saveUser(tbUserDto).getUserId();
    }
}
