package com.useraccount;

import com.classfuse.annotations.Component;
import com.classfuse.annotations.Infused;
import com.useraccount.services.AccountService;
import com.useraccount.services.UserService;

@Component
public class UserAccountClientComponent {
    @Infused
    private UserService userService;
    @Infused
    AccountService accountService;

    public void displayUserAccount() {
        String username = userService.getUsername();
        Long accountNumber = accountService.getAccountNumber(username);
        System.out.println("\n\tUser Name: " + username + "\n\tAccount Number: " + accountNumber);
    }
}
