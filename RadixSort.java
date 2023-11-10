import java.util.*;
import java.io.*;
import java.util.Hashtable;
import java.util.LinkedList;

public class RadixSort {

    /**
     * Sorts a file of words using radix sort and returns a sorted file
     *
     * @param f the path of file
     * @throws IOException
     */
    public static void radixSort(File f) throws IOException {

        // Creates string of words from file
        String t = "";
        // Counts number of words in file
        int c = 0;

        // Takes in word from file
        File file = f;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {

            String word = scanner.nextLine();

            if (word.length() != 0) {

                c++;
                t += (word + " ");

            }

        }

        // Takes string of words and makes into array of words
        String[] input = new String[c];
        for (int h = 0; h < c; h++) {

            input[h] = t.substring(0, t.indexOf(" "));
            t = t.substring(t.indexOf(" ") + 1);

        }

        // creates a hashtable of linked lists, one linked list for each letter of the alphabet
        Hashtable<Character, LinkedList<String>> words = new Hashtable<>(26);

        for (char letter = 'a'; letter <= 'z'; letter++) {

            LinkedList<String> linkedList = new LinkedList<>();

            words.put(letter, linkedList);

        }

        int longest = 0;

        // determines the longest word length
        for (String s : input) {

            if (s.length() > longest) {

                longest = s.length();

            }

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
            for (int m = 0; m < input.length; m++) {

                String temp = input[m];

                if (input[m] != null) {

                    input[n] = temp;

                    n++;

                }

            }

            // adds organized values to end of input in order
            for (char letter = 'a'; letter <= 'z'; letter++) {

                while (!words.get(letter).isEmpty()) {

                    input[n] = words.get(letter).remove();
                    n++;

                }

            }

        }

        // creates new file to return sorted words
        File newFile = new File(file.getName().substring(0, file.getName().length() - 4) + "_key.txt");

        if (newFile.createNewFile()) {

            System.out.println("File created: " + newFile.getName());

        } else {

            System.out.println("file already exists.");

        }

        try {

            FileWriter writer = new FileWriter(newFile.getName());

            // writes sorted words to file
            for(int n = 0; n < input.length; n++) {

                writer.write(input[n] + "\n\n");

            }

            writer.close();

            System.out.println("Done!");

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();

        }

    }

    public static void main(String[] args) throws IOException {

        radixSort(new File("C:\\Users\\mariev718_lpsk12\\IdeaProjects\\radix-sort-mariev718\\.idea\\input.txt"));

    }

}