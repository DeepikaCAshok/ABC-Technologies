package com.mycompany.app;

/**
 * Hello world!
 */
public class App {

    private static final String MESSAGE = "Hello World!";

    public App() {}

    public static void main(String[] args) throws InterruptedException {
        System.out.println(MESSAGE);

        while (true) {
            Thread.sleep(1000);
        }
    }

    public String getMessage() {
        return MESSAGE;
    }
}
