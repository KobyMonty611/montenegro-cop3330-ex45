package ex45;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class writeFile
{
    //Attributes
    private FileWriter writingInfo;
    private ArrayList<String> sentenceList;

    //Constructor
    public writeFile(String name, ArrayList<String> outputList) throws IOException
    {
        writingInfo = new FileWriter("src/main/java/ex45/" + name);
        this.sentenceList = outputList;
    }

    //Function
    public void writeToFile() throws IOException
    {
        for (int i = 0; i < sentenceList.size(); i++)
        {
            //Create string to get sentences from the list
            String replace = sentenceList.get(i);

            //Replaces any instance of utilize with use in the string
            replace = replace.replaceAll("utilize", "use");

            //Writes it into file
            writingInfo.write(replace + "\n");
        }

        // close the writer object
        writingInfo.close();
    }

}