package Oleg;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter your code: ");
        System.out.println("Enter your password: ");


        int userNum = scan.nextInt();
        int userPas = scan.nextInt();


        if (userNum == 1337228) {
            System.out.println("Your Code is correct");

        } else {
             System.out.println("Wrong operation");
            if (userPas == 999333) {
                 System.out.println("Your password is correct");

            } else {
                    System.out.println("Wrong operation");

            }
        }
}
}
