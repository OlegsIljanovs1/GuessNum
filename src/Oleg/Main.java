package Oleg;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String answer;

        do {

            askString("Please enter your name: ");
            boolean userWon = false;
            int myNum = rand.nextInt(100) + 1;

            for (int i = 0; i < 10; i++) {
                int userNum = askInt("Enter your guess: ", 1, 100);
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


        } while (askStr("Do you want to play again?"));


    }

    static int askInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int answer = scan.nextInt();
                if (answer >= min && answer <= max) {
                    return answer;
                }
            } catch (InputMismatchException ex) {
                System.out.println("It isn't a number");
                scan.next();
            }
            System.out.printf("Please enter number from %d to %d\n", min, max);
        }

    }

    static boolean askStr(String msg) {
        while (true) {
            System.out.println(msg);
            String answer = scan.next();
            boolean isY = answer.equalsIgnoreCase("y");
            boolean isN = answer.equalsIgnoreCase("n");
            if (isY || isN) {
                return isY;
            }
            System.out.println("Enter 'y' or 'n'");
        }

    }

    static String askString(String msg) {
        System.out.println(msg);
        String answer = scan.next();
        return answer;



    }





    }


