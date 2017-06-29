package com.company;

import java.util.Scanner;

public class Main {
    public static void yesno(String yn, String yes, String no){
        if(yn.equals("yes") || yn.equals("Yes")){
            System.out.println(yes);
        }
        else {
            System.out.println(no);
        }
    }
    public static void main(String[] args) {
        //misc vars:
        String answer;
        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Welcome to Eli and Jack's text adventure, you idiot!\nPlease answer yes/no to yes or no questions and the question number for multiple answer questions. (For instance: Q: Buy a sword, 1. Buy a potion, 2. A: If you want to buy a sword, enter 1.)\nWe'd like to ask you a few questions. First, what's your full name? (First and last)");
        String name = consoleInput.nextLine();
        String[] parts = name.split(" ");
        String fname = parts[0];
        String lname = parts[1];
        System.out.println("Hello " + fname);
        System.out.print("Enter your age (in years): ");
        float age = consoleInput.nextFloat();
        if(age > 130){
            System.out.println("Are you sure?");
            answer = consoleInput.next();
            yesno(answer, "You are " + age + " years old", "Too bad for you.\n\nYou are " + age + " years old");
        }
        else if(age <= 0){
            System.out.println("You are from the future.");
        }
        else{
            System.out.println("You are " + age + " years old.");
        }
        System.out.println("What is your gender, " + fname + ", you idiot? (man, woman, boy, etc.)");
        String gender = consoleInput.next();
        String pro;
        if(gender.equals("boy") || gender.equals("Boy") || gender.equals("man") || gender.equals("Man")){
            pro = "Mr. ";
        }else if(gender.equals("girl") || gender.equals("Girl") || gender.equals("woman") || gender.equals("Woman")) {
            pro = "Ms. ";
        }else{
            pro = fname + " ";
        }
        String formalname = pro + lname;
        System.out.print("Enter your credit card number, " + formalname + " : ");
        long credit = consoleInput.nextLong();
        int cash = 100000;
        int length = String.valueOf(credit).length();
        while (length < 14 || length > 16){
            System.out.print("Tsk, tsk! That is not your credit card number.\nTry again: ");
            credit = consoleInput.nextLong();
            length = String.valueOf(credit).length();
        }
        System.out.print("Correct! Let's begin!");
        System.out.println(" Your cash on hand is " + cash + ".");
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println((char)27 + "[31;0mAn unauthorized source would like to use your credit card. Would you like to allow this transaction?");
        answer = consoleInput.next();
        System.out.println("Great! Access granted! $500,000 has been taken from your account. Would you like to allow another transaction?");
        answer = consoleInput.next();
        System.out.println("Great! Access granted again! $1.2e+52 has been taken from your credit account! Your bank expects you to pay it back within a month!");
        System.out.println((char)27 + "[0;0mLet's continue!");
        System.out.println("You are in a town. A gigantic duck, twice your size, with a sword walks up to you. He says, 'my name's Gary. Like to come to my house and meet my daughter?\nShe's considered a beauty among giant ducks.'");
        System.out.println("Would you like to meet Gary's daughter? Answer yes or no.");
        String gary = consoleInput.next();
        yesno(gary, "Gary leads you to his house, where a smaller duck awaits, sitting in an armchair.", "You walk away from Gary. 'You've made an enemy today, " + formalname + "! I'm not happy!' He says.\n'How do you know my name, Joe?' You ask.\n'I know many things about you. Including your credit card number.'\n He throws his head back and laughs.");
        if(gary.equals("yes") || gary.equals("Yes")){
            System.out.println("She is clearly a female duck, and she invites you up to her room.\n'Why hello, " + formalname + ". I've heard so much about you. Is it true your credit card number is " + credit + "? How interesting.\n\nJoe's daughter is obviously creepy. Would you like to run away?");
            answer = consoleInput.next();
            yesno(answer, "You run away from the house and hear a scream of rage. 'You'll PAY for this!' Gary yells.", "You stay at the house, and Gary's daughter, who introduces herself as Gertie, invites you down to the kitchen.");
            if(answer.equals("yes") || answer.equals("Yes")){
                System.out.println((char)27 + "[31;0mAn unauthorized source (called Gary) would like to use your credit card. Would you like to allow this transaction?");
                answer = consoleInput.next();
                System.out.println((char)27 + "Great! you have authorized this payment of $10,000.");
                cash -= 10000;
                System.out.println((char)27 + "[0;0mYour cash on hand is " + cash + ".");
            }else{
                System.out.println("You have decided to stay.\n'Let me show you the kitchen! We'll be eating soon. I'm so excited to eat y- that is, with you,' she says\nYou go down to the kitchen and she shows you around. Suddenly she grabs you and slams you down on a giant cutting board. She quickly chops your head off.\nThe duck family eats you, leaving only your heart and brain. Gary says, 'If you give me the pin code of your credit card, I'll resurrect you.'\n\nWould you like to give Gary your pin code?");
                answer = consoleInput.next();
                yesno(answer, "You give Gary your pin code and he resurrects you. 'GET OUT!' He shouts.", "You lose the game.");
                if(answer.equals("no") || answer.equals("No") || answer.equals("NO")){
                    System.exit(0);
                }else{
                    System.out.println((char)27 + "[31;0mAn unauthorized duck (called Gary) would like to use your credit card. Would you like to allow this transaction?");
                    answer = consoleInput.next();
                    System.out.println((char)27 + "Great! you have authorized this payment of $10,000.");
                    cash -= 10000;
                    System.out.println((char)27 + "[0;0mYour cash on hand is " + cash + ".");
                }
            }
        }
        /*
        Continue here from Gary's daughter or skip it - remember, later on use
        if(gary.equals("yes") || gary.equals("Yes")){
            System.out.println((char)27 + "[31;0mAn unauthorized source (called Gary) would like to use your credit card. Would you like to allow this transaction?");
            answer = consoleInput.next();
            System.out.println((char)27 + "Great! you have authorized this payment of $10,000.");
            cash -= 5000;
            System.out.println((char)27 + "[0;0mYour cash on hand is " + cash + ".");
        }
        */
    }
}
