package com.module.process.user;

import com.module.core.annotation.JwtAuth;
import com.module.core.jwt.JwtDto;
import com.module.core.jwt.JwtProvider;
import com.module.db.user.entity.TbUser;
import com.module.db.user.model.TbUserDto;
import com.module.domain.user.rest.UserRest;
import com.module.process.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/user")
@RestController
@Slf4j
public class UserProcess implements UserRest {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public JwtDto emailLogin(@RequestBody TbUserDto userDto) {
        TbUser tbUser = userService.emailLogin(userDto);
        return jwtProvider.generateJwt("userId", tbUser.getUserId());
    }

    @Override
    @JwtAuth
    public JwtDto jwtLogin(Long userId) {
        TbUser tbUser = userService.findById(userId);
        return jwtProvider.generateJwt("userId", tbUser.getUserId());
    }

    @Override
    public JwtDto signup(@RequestBody TbUserDto tbUserDto) {
        TbUser tbUser = userService.signup(tbUserDto);
        return jwtProvider.generateJwt("userId", tbUser.getUserId());
    }

    @Override
    @JwtAuth
    public TbUserDto findUser(Long userId) {
        System.out.println("userId : " + userId);
        TbUser tbUser = userService.findById(userId);
        return userService.of(tbUser);
    }
}
