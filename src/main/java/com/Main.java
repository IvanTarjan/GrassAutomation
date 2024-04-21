package com;

import com.SeleniumRunner.SeleniumRunner;

public class Main {
    public static void main(String[] args) {
        String chromePath = args[0];
        System.out.println(chromePath);
        String username = args[1];
        System.out.println(username);
        String password = args[2];
        System.out.println(password);
        SeleniumRunner testsFront = new SeleniumRunner(chromePath, username, password);
        try {
            testsFront.setUp();
            testsFront.login();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}