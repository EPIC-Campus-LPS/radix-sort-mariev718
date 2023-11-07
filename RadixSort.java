import java.util.*;
import java.io.*;
public class RadixSort {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter file name containing words to be sorted without '.txt'");

        String fileName = in.nextLine();

        Hashtable<Integer, String> words = new Hashtable<>(26);

        File input = new File(fileName + ".txt");

        try {

            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {

                String word = scanner.nextLine();

                if(word.length() != 0) {



                }

            }

            scanner.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }

        while(!words.isEmpty()) {

            System.out.println(words.remove());

        }

    }

}
