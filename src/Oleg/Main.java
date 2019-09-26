package Oleg;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter your guess: ");
        String answer;

        do {


            boolean userWon = false;

            for (int i = 0; i < 10; i++) {

                int myNum = rand.nextInt(100) + 1;
                int userNum = scan.nextInt();
                {

                    if (myNum == userNum) {
                        System.out.println("You won");
                        userWon = true;
                        break;

                    } else if (myNum < userNum) {
                        System.out.println("My number is smaller than yours");

                    } else {
                        System.out.println("My number is bigger than yours");
                    }

                }
                if (!userWon) {
                    System.out.println("Loser!");

                }


            }
            System.out.println("Would you like to play again? (y/n)");

            answer = scan.next();
        } while (answer.equals("y"));

    }
}

