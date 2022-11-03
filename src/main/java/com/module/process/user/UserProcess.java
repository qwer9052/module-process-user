package com.module.process.user;

import com.module.core.annotation.JwtAuth;
import com.module.core.jwt.JwtDto;
import com.module.core.jwt.JwtProvider;
import com.module.core.jwt.JwtTokenDto;
import com.module.domain.user.model.TbUserDto;
import com.module.domain.user.rest.UserRest;
import com.module.process.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/v1/user")
@RestController
@Slf4j
public class UserProcess implements UserRest {

    @Autowired
    UserService userService;

    @Autowired
    JwtProvider jwtProvider;

    @Override
    @GetMapping
    @JwtAuth
    public Long findUser(Long userId) {
        System.out.println("userId : " + userId);
        return userService.findByUserId(userId).getUserId();
    }

    @Override
    public JwtDto signup(@RequestBody TbUserDto tbUserDto) {

        Long userId = userService.signup(tbUserDto);
        JwtDto jwtDto = jwtProvider.generateJwt("userId", userId);

        return jwtDto;
    }
}
