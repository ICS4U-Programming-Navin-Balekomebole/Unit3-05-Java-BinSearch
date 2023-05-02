import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
* The program will use
* a binary search to find the index
* of a number.
*
* @author  Navin Balekomebole
* @version 1.0
* @since   2023-05-01
*/

public final class RecBinSearch {
    /**
    * For style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private RecBinSearch() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print messages.
    *
    * @param args Unused
    */
    public static void main(String[] args) {
        // Declare the list.
        // Declare the variable.
        final ArrayList<String> inputList = new ArrayList<String>();
        String indexStr = "";

        try {
            // file for the input.
            final File input = new File("input.txt");
            final Scanner scanInput = new Scanner(input);

            // file for the output.
            final FileWriter output = new FileWriter("output.txt");

            // A Loop is used to
            // read every line of the input file.
            while (scanInput.hasNextLine()) {
                inputList.add(scanInput.nextLine());
            }

            // Small description here below...
            // an array is created
            // with all elements in the input list.
            final String[] inputArr = new String[inputList.size()];
            for (int location = 0; location < inputArr.length; location++) {
                inputArr[location] = inputList.get(location);
            }

            // The Loop is here
            // to send each array to a function.
            for (int counter = 0; counter < inputArr.length; counter += 2) {
                // The program will Convert inputArr to int.
                final int[] arrOfInt =
                    new int[inputArr[counter].split(" ").length];
                for (int place = 0;
                    place < inputArr[counter].split(" ").length; place++) {
                    arrOfInt[place] = Integer.parseInt(
                        inputArr[counter].split(" ")[place]);
                }

                // Sort array.
                Arrays.sort(arrOfInt);

                // Get number to search for.
                final int intSearch = Integer.parseInt(inputArr[counter + 1]);

                // Call function to search array.
                final int index = searchBin(arrOfInt, intSearch,
                    0, arrOfInt.length - 1);
                indexStr = indexStr + index + "\n";
            }

            // Write to output file.
            output.write(indexStr);
            output.close();
            System.out.println(indexStr);
        } catch (IOException err) {
            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
    * This function uses a binary search to find a number.
    *
    * @param listOfNum from file
    * @param searchNum from file
    * @param startIndex of list
    * @param endIndex of list
    * @return index of the number
    */
    public static int searchBin(int[] listOfNum, int searchNum,
        int startIndex, int endIndex) {
        // Base case 1:
        // Also described as
        // the number not found in list.
        if (startIndex > endIndex) {
            return -1;
        }

        // Set the mid point.
        final int mid = (startIndex + endIndex) / 2;

        // if statement used.
        if (listOfNum[mid] == searchNum) {
            return mid;
        } else if (listOfNum[mid] > searchNum) {
            return searchBin(listOfNum, searchNum, startIndex, mid - 1);
        } else {
            // Returns the list of numbers.
            return searchBin(listOfNum, searchNum, mid + 1, endIndex);
        }
    }
}
