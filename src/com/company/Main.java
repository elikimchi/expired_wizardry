package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Welcome to Eli and Jack's text adventure, you idiot!\nPlease answer yes/no to yes or no questions and the question number for multiple answer questions. (For instance: Q: Buy a sword, 1. Buy a potion, 2. A: If you want to buy a sword, enter 1.)\nWe'd like to ask you a few questions. First, what's your name? (First name only)");
        String name = consoleInput.next();
        System.out.println("Now, how old are you? (In years, you dumbbell)");
        int age = consoleInput.nextInt();

    }
}
