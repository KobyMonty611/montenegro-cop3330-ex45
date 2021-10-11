/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Koby Montenegro
 */

package ex45;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) throws IOException
    {
        //Ask the user for the output name
        System.out.print("Enter the name of the Output File in the format of ''name.txt'': ");
        Scanner scan = new Scanner(System.in);
        String outputFileName = scan.next();

        //Create new object so we can read the file
        readFile readFileData = new readFile();
        readFileData.readTheInfo();

        //Create a list and then get the data from the file
        ArrayList<String> dataList = readFileData.getData();

        //Create new object so we can use the outputFileName and dataList to create the file itself
        writeFile writeFileData = new writeFile(outputFileName, dataList);
        writeFileData.writeToFile();
    }
}