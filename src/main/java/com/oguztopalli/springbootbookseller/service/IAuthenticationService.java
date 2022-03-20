package com.oguztopalli.springbootbookseller.service;

import com.oguztopalli.springbootbookseller.model.User;

public interface IAuthenticationService {
    User signInAndReturnJWT(User singInRequest);
}
