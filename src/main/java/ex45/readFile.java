package ex45;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class readFile
{
    //Attributes
    private ArrayList<String> sentenceLine;
    private Scanner scan;

    //Constructor
    public readFile() throws FileNotFoundException
    {
        sentenceLine = new ArrayList<String>();

        File inputFile = new File("src/main/java/ex45/exercise45_input.txt");
        scan = new Scanner(inputFile);
    }

    //Function
    public void readTheInfo()
    {
        //Reads the file and stores the data line by line
        while(scan.hasNext())
        {
            String fileData = scan.nextLine();
            sentenceLine.add(fileData);
        }
        scan.close();
    }

    //Return
    public ArrayList<String> getData()
    {
        return sentenceLine;
    }
}
