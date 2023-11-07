import java.util.*;
import java.io.*;

import static java.lang.Character.getNumericValue;

import java.util.Hashtable;
import java.util.LinkedList;

import static java.lang.Character.getNumericValue;

public class RadixSort {

    public static void main(String[] args) {

        // MAKE INPUT GO TO INPUT ARRAY

//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter file name containing words to be sorted without '.txt'");
//
//        String fileName = in.nextLine();
//
//        Hashtable<Integer, String> words = new Hashtable<>(26);
//
//        File input = new File(fileName + ".txt");
//
//        try {
//
//            Scanner scanner = new Scanner(input);
//
//            while (scanner.hasNextLine()) {
//
//                String word = scanner.nextLine();
//
//                if(word.length() != 0) {
//
//                    char letter = word.toLowerCase().charAt(0);
//                    int index = getNumericValue(letter);
//
//                    words.put(index, word);
//
//                }
//
//            }
//
//            scanner.close();
//
//        } catch (FileNotFoundException e) {
//
//            e.printStackTrace();
//
//        }

        String[] input = {"enthusiasm", "milder", "STENCILED", "LIBELEES", "ReFurbISHMENT", "ComMANDEERs",
                "spectroscopy", "DiSeMbOdyING", "pAnDErING", "EXPLORATIONS"};

        Hashtable<Character, LinkedList<String>> words = new Hashtable<>(26);

        for (char letter = 'a'; letter <= 'z'; letter++) {

            LinkedList<String> linkedList = new LinkedList<>();

            words.put(letter, linkedList);

        }

        int longest = 0;

        // determines the longest word length
        for (int i = 0; i < input.length; i++) {

            if (input[i].length() > longest) longest = input[i].length();

        }

        // organizes words by letter at last index to first index
        for (int l = longest; l > 0; l--) {

            // organizes words by letter at specific index
            for (int j = 0; j < input.length; j++) {

                if (input[j].length() >= l) {

                    char letter = input[j].toLowerCase().charAt(l - 1);
                    words.get(letter).add(input[j]);

                    input[j] = null;

                }

            }

            int n = 0;

            // reassigns values not used to beginning of input list
            for(int m = 0; m < input.length; m++) {

                String temp = input[m];

                if(input[m] != null) {

                    input[n] = temp;

                    n++;

                }

            }

            // adds organized values to end of input in order
            for (char letter = 'a'; letter <= 'z'; letter++) {

                while(!words.get(letter).isEmpty()) {

                    input[n] = words.get(letter).remove();
                    n++;

                }

            }

        }

        for(int p = 0; p < input.length; p++) {

            System.out.println(input[p]);

        }

    }

}
