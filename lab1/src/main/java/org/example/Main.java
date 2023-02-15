package org.example;
//Objective: To understand and use Strings in Java.
//Instructions:
//Declare and initialize a String variable.
//Use String methods (e.g., length, substring, indexOf, toUpperCase, toLowerCase) to manipulate the String.
//Print the result of each operation to the console.
public class Main {
    public static void main(String[] args)  {
        String str = "Hello World!";
        System.out.println(str.length());
        System.out.println(str.substring(2, 7));
        System.out.println(str.indexOf('o'));
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
    }
}