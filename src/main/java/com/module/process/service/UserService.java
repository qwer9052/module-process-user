package com.module.process.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.module.core.exception.CommonException;
import com.module.core.util.StringUtil;
import com.module.db.user.entity.TbUser;
import com.module.db.user.model.TbUserDto;
import com.module.domain.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ObjectMapper mapper;


    public TbUserDto of(TbUser tbUser){
        return mapper.convertValue(tbUser, TbUserDto.class);
    }

    public TbUser findById(Long userId) throws CommonException {
        return userRepo.findById(userId);
        //return mapper.convertValue(tbUser, TbUserDto.class);
    }

    public TbUser emailLogin(TbUserDto tbUserDto) {
        tbUserDto.setPwd(StringUtil.getSHA256(tbUserDto.getPwd()));
        TbUser tbUser = userRepo.findByEmailAndPwd(tbUserDto.getEmail(), tbUserDto.getPwd())
                .orElseThrow(() -> new CommonException("존재하지 않는 회원 pk입니다."));
        return tbUser;
    }

    public TbUser signup(TbUserDto tbUserDto) {

        Optional<TbUser> tbUser = userRepo.findByEmail(tbUserDto.getEmail());

        tbUser.ifPresent(user -> {
            throw new CommonException("이미 존재하는 아이디 입니다.");
        });

        //비밀번호 암호화
        tbUserDto.setPwd(StringUtil.getSHA256(tbUserDto.getPwd()));

        return userRepo.saveUser(tbUserDto);
    }
}
