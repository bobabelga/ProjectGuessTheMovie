package com.bobabelga;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GuessMovie {
    public static void main(String[] args) {
        File file = new File("movies.txt");
        try {
            Scanner scanner = new Scanner(file);
            ArrayList<String> moviesList = new ArrayList<>();
            while (scanner.hasNext())
                moviesList.add(scanner.nextLine());

            // choose random movie
            int random = (int) ((Math.random()) * moviesList.size());
            String randomMovie = moviesList.get(random);

            // loop of number of guess
            int i = 0;
            String wrongLetter = "";
            char[] rightLetters = new char[randomMovie.length()];
            while (i <= 9) {

                System.out.print("Guess a Letter : ");


                // listening to user input
                Scanner scanner1 = new Scanner(System.in);
                String userInput = scanner1.nextLine();

                // add spaces to rightletters list
                int indexSpace = randomMovie.indexOf(" ");
                while (indexSpace >= 0) {
                    rightLetters[indexSpace] = ' ';
                    indexSpace = randomMovie.indexOf(" ", indexSpace + 1);
                }
                //test if the letter is include the title
                int index = randomMovie.indexOf(userInput);
                if (index >= 0) {
                    while (index >= 0) {
                        rightLetters[index] = randomMovie.charAt(index);
                        index = randomMovie.indexOf(userInput, index + 1);
                    }

                } else {
                    wrongLetter += userInput + " ";
                    i++;
                }

                String testMovie = "";
                for (char c : rightLetters) {
                    if (c == 0) {
                        testMovie += "_";
                    } else testMovie += c;
                }
                System.out.println("You are Guessiong : " + testMovie);
                System.out.println("You Have Guessed (" + i + ") Wrong Letter(s) " + wrongLetter);
                if (testMovie.equals(randomMovie)) {
                    System.out.println("You win ");
                    break;
                }
                if (i > 9) {
                    System.out.println("Game Over");
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
    }
}
