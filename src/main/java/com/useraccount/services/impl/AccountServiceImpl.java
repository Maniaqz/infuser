package com.useraccount.services.impl;

import com.classfuse.annotations.Component;
import com.useraccount.services.AccountService;

@Component
public class AccountServiceImpl implements AccountService {
    @Override
    public Long getAccountNumber(String username) {
        return 123L;
    }
}
