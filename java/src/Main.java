import java.io.File;
import java.util.ArrayList;
public class Main {
    //Set the directories of each object HERE
    public static final String DIRECTORY_OF_INPUT = "/var/www/html/km6sqn/java/src/uploads/tempFile.txt";
    public static final int LENGTH_OF_FILE = 3417;
    public static final String DIRECTORY_OF_OUTPUT = "output";



    /*
    QUESTION BREAKDOWN SEGMENTS: - Read Documentation for more information
    SUBELEMENT - TOPEX - Comment
    SUBEX - Comment
    Questions
    ~~
    SUBEX - Comment
    Questions
    ~~
     */
    public static void main(String[] args) {
        //Code Segment Breaks Text into File
        getFile tempFile = new getFile(DIRECTORY_OF_INPUT, LENGTH_OF_FILE); // Create new file
        System.out.println("Imported File...");
        String[] tempLines = tempFile.getLines(); //Return into Lines
        System.out.println("Converted to Lines: " + tempLines.length + " Lines in array");



        //Filter all lines in array to only topics (Identifiable by having empty string one before and one after)
        ArrayList<String> tempTopics = new ArrayList<>();
        for(int i = 1; i < tempLines.length - 1; i++){
            if(tempLines[i] != "" && tempLines[i - 1] == "" && tempLines[i + 1] == ""){
                tempTopics.add(tempLines[i]);
                i++;
            }
        }
        System.out.println("TempTopics: " + tempTopics);


        //Store each line from temporary array into proper objects.
        ArrayList<Topics> allTopics = new ArrayList<>();
        for(int i = 0; i < tempTopics.size(); i++){
            if(tempTopics.get(i).indexOf("SUBELEMENT") != -1){ //Topics Identifiable by the word "Subelement"
                ArrayList<String> subTopics = new ArrayList<>();
                for(int j = i + 1; j < tempTopics.size(); j++){ // Search the rest of the subtopics. If "SUBELEMENT" is found, creates new topic
                  if(tempTopics.get(j).indexOf("SUBELEMENT") == -1) subTopics.add(tempTopics.get(j));
                  else break;
                }
                allTopics.add(new Topics(tempTopics.get(i), subTopics)); //Store subtopics into new array
            }
        }
        for(Topics printTopics: allTopics){
            System.out.println(printTopics.getTitle());
            System.out.println(printTopics.getSubTopics());
        }






    }
}