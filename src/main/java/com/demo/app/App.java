package com.demo.app;

/**
 * Hello world!
 */
public class App {

    private static final String MESSAGE = "Hello Jenkins!";

    public App() {}

    public static void main(String[] args) {
        System.out.println(MESSAGE);
    }

    public String getMessage() {
        return MESSAGE;
    }
}