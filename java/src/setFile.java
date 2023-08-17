import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;
import java.io.FileWriter;   // Import the FileWriter class

public class setFile {
    public setFile(String filePath, ArrayList<String> objects){
        try {
            FileWriter myWriter = new FileWriter(filePath);
            for(String object : objects){
                myWriter.write(object);
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}

