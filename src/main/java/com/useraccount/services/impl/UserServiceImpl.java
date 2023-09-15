package com.useraccount.services.impl;

import com.classfuse.annotations.Component;
import com.useraccount.services.UserService;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public String getUsername() {
        return "username";
    }
}
