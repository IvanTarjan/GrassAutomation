package com.Main;


import com.SeleniumRunner.SeleniumRunner;

public class Main {
    public static void main(String[] args) {
        String chromePath = args[0];
        System.out.println(chromePath);
        String username = args[1];
        String password = args[2];
        System.out.println("Starting");
        SeleniumRunner testsFront = new SeleniumRunner(chromePath, username, password);
        try {
            testsFront.setUp();
            testsFront.login();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished Setting Up");
    }
}