package com.Main;


import com.SeleniumRunner.SeleniumRunner;

public class Main {
    public static void main(String[] args) {
        String username = args[0];
        String password = args[1];
        System.out.println("Starting");
        SeleniumRunner testsFront = new SeleniumRunner(username, password);
        try {
            testsFront.setUp();
            testsFront.login();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished Setting Up");
    }
}