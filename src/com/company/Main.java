package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Welcome to Eli and Jack's text adventure, you idiot!\nPlease answer yes/no to yes or no questions and the question number for multiple answer questions. (For instance: Q: Buy a sword, 1. Buy a potion, 2. A: If you want to buy a sword, enter 1.)\nWe'd like to ask you a few questions. First, what's your name? (First name only)");
        String name = consoleInput.nextLine();
        String[] parts = name.split(" ");
        String fname = parts[0]; // 004
        String lname = parts[1];
        System.out.println("Hello " + name);
        System.out.println("Now, how old are you? (In years, you dumbbell)");
        float age = consoleInput.nextFloat();
        if(age > 130){
            System.out.println("Are you sure?");
            String str = consoleInput.next();
            if(str.equals("yes")){
                System.out.println("You are " + age + " years old.");
            }
            else if(str.equals("no")){
                System.out.println("Too bad for you.");
            }
        }
        else if(age <= 0){
            System.out.println("You are from the future.");
        }
        else{
            System.out.println("You are " + age + " years old.");
        }
        System.out.print("Enter your credit card number: ");
        int credit = consoleInput.nextInt();
        System.out.println("Let's begin!");
    }
}
