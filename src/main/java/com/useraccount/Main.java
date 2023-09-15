package com.useraccount;

import com.classfuse.Infuser;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Infuser.startApplication(Main.class);
        Infuser.getService(UserAccountClientComponent.class).displayUserAccount();
        long endime = System.currentTimeMillis();
    }
}