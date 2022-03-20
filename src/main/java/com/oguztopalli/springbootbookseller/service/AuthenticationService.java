package com.oguztopalli.springbootbookseller.service;

import com.oguztopalli.springbootbookseller.model.User;
import com.oguztopalli.springbootbookseller.security.UserPrincipal;
import com.oguztopalli.springbootbookseller.security.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements  IAuthenticationService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IJwtProvider jwtProvider;

    @Override
    public User signInAndReturnJWT(User singInRequest)
    {
        Authentication authentication=authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(singInRequest.getUsername(),singInRequest.getPassword())
        );

        UserPrincipal userPrincipal= (UserPrincipal) authentication.getPrincipal();
        String jwt=jwtProvider.generateToken(userPrincipal);

        User signInUser=userPrincipal.getUser();
        signInUser.setToken(jwt);

        return signInUser;
    }



}
