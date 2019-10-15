package Oleg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    static ArrayList<GameResult> LeaderBoard = new ArrayList<>();
    public static void main(String[] args) {
        loadResults();
        String answer;

        do {

            String userName = askString("Please enter your name: ");
            boolean userWon = false;
            int myNum = rand.nextInt(100) + 1;
            long t1 = System.currentTimeMillis();

            for (int i = 0; i < 10; i++) {
                int userNum = askInt("Enter your guess: ", 1, 100);

                {

                    if (myNum == userNum) {
                        long t2 = System.currentTimeMillis();
                        GameResult r = new GameResult();
                        r.setName(userName);
                        r.setTriesCount(i + 1);
                        r.setTime(t2 - t1);
                        LeaderBoard.add(r);
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

        showResults2();
        file();


    }

    private static void loadResults() {
        File file = new File("Myfile.txt");
        try (Scanner in = new Scanner(file)) {

            while (in.hasNext()){

                GameResult r = new GameResult();

                String name = in.next();
                int tries = in.nextInt();
                long time = in.nextLong();

                r.setName(name);
                r.setTriesCount(tries);
                r.setTime(time);

                LeaderBoard.add(r);
            }
        }catch (IOException e ){
            System.out.println("Cannot read leader board");
        }

    }

    private static void file(){


        File file = new File("Myfile.txt");
        try (PrintWriter out = new PrintWriter(file)){

            for (GameResult result : LeaderBoard) {
                out.printf("%s %d %d\n", result.getName(), result.getTriesCount(), result.getTime());
            }

        } catch (IOException e) {
            System.out.println("Error!!! Try again");
        }
    }

   /* private static void ShowResult() {
        LeaderBoard.sort(Comparator
                .comparing(GameResult::getTriesCount)
                .thenComparing(GameResult::getTime));

        for (GameResult result : LeaderBoard) {
            System.out.printf("%s \t\t\t %d %d\n", result.getName(), result.getTriesCount(), result.getTime() / 1000);



    }*/

    private static void showResults2(){
        LeaderBoard.stream()
                .sorted(Comparator
                    .comparingInt(GameResult::getTriesCount)
                    .thenComparing(GameResult::getTime))
                .limit(5)
                .forEach(r -> System.out.printf("%s \t\t\t %d tries \t\t\t %d seconds\n",
                        r.getName(),
                        r.getTriesCount(),
                        r.getTime() / 1000));

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


