import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class getFile {
    private String fileName;
    private int fileLines;
    public getFile(String fileNameInput, int fileLinesInput){
        fileName = fileNameInput;
        fileLines = fileLinesInput;
    }
    public String[] getLines(){
        Scanner inputStream = null;
        String tempFileData[] = new String[fileLines];
        try {
            inputStream = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + fileName);
            System.exit(23);
        }
        int counter = 0;
        while(inputStream.hasNextLine()){
            tempFileData[counter] = inputStream.nextLine();
            counter++;
        }

        return tempFileData;
    }

    public int[] getNumberLines(String input[]){
        int[] inputNumbers = new int[input.length];
        for(int i = 0; i < inputNumbers.length; i++){
            if(input[i] == "" || input[i] == null){}
            else inputNumbers[i] = Integer.parseInt(input[i]);
        }
        return inputNumbers;
    }
}
