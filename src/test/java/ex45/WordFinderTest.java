package ex45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WordFinderTest
{
    @Test
    void readTheInfo() throws FileNotFoundException
    {
        //Allows the file to be accessed
        File test45 = new File("src/main/java/ex45/exercise45_input.txt");

        //Add sentences into ArrayList
        ArrayList<String> actual = new ArrayList<String>();
        actual.add("One should never utilize the word \"utilize\" in writing. Use \"use\" instead.");
        actual.add("For example, \"She uses an IDE to write her Java programs\" instead of \"She");
        actual.add("utilizes an IDE to write her Java programs\".");

        ArrayList<String> expected = new ArrayList<String>();
        Scanner scan = new Scanner(test45);

        while (scan.hasNextLine())
        {
            String sentence = scan.nextLine();
            expected.add(sentence);
        }
        scan.close();

        //THIS IS WHERE THE COMPARISON HAPPENS
        assertEquals(expected, actual);
    }

    @Test
    void writeToFile() throws IOException
    {
        //Allows the file to be accessed
        FileWriter writeToFile = new FileWriter("src/test/java/ex45/exercise45_testOutput.txt");

        //Add sentences into ArrayList
        ArrayList<String> actualList = new ArrayList<String>();
        actualList.add("One should never utilize the word \"utilize\" in writing. Use \"use\" instead.");
        actualList.add("For example, \"She uses an IDE to write her Java programs\" instead of \"She");
        actualList.add("utilizes an IDE to write her Java programs\".");

        for (int i = 0; i < actualList.size(); i++)
        {
            //Create string to get sentences from the list
            String replace = actualList.get(i);

            //Replaces any instance of utilize with use in the string
            replace = replace.replaceAll("utilize", "use");

            //Writes it into file
            writeToFile.write(replace + "\n");
        }

        writeToFile.close();

        //THIS IS WHERE THE COMPARISON HAPPENS
        //Opens the file, reads the file into a byte array, and then closes it
        //Used to compare the two later
        //This is the original
        String expected = new String(Files.readAllBytes
                (Paths.get("src/main/java/ex45/exercise45_output.txt")), StandardCharsets.UTF_8);

        //This is the new one in this class
        String actual = new String(Files.readAllBytes
                (Paths.get("src/test/java/ex45/exercise45_testOutput.txt")), StandardCharsets.UTF_8);

        //Compares both strings to see if they were equal
        assertEquals(expected, actual);
    }

}

