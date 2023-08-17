import java.io.File;
import java.util.ArrayList;
public class Main {
    //Set the directories of each object HEREu
    public static final String DIRECTORY_OF_INPUT = "/var/www/html/km6sqn/uploads/tempFile.txt";
    public static final int LENGTH_OF_FILE = 3417; //NEED TO CHANGE
    public static final String DIRECTORY_OF_OUTPUT = "/var/www/html/km6sqn/downloads/download.json";

    /*
    QUESTION BREAKDOWN SEGMENTS: - Read Documentation for more information
    SUBELEMENT - TOP - EX - Comment
    SUBEX - Comment
    Questions
    ~~
    SUBEX - Comment
    Questions
    ~~
     */
    public static void main(String[] args) {
        String path = new File("src/main/resources/conf.properties").getAbsolutePath(); //Get the Path of the Upload file
        System.out.println(path);

        //Code Segment Breaks Text into File
        getFile tempFile = new getFile(DIRECTORY_OF_INPUT, LENGTH_OF_FILE); // Create new file
     //   System.out.println("Imported File...");
        String[] fileTempLines = tempFile.getLines(); //Return into Lines
       // System.out.println("Converted to Lines: " + fileTempLines.length + " Lines in array");

        /* //Debug Purposes
        for(int i = 0; i < fileTempLines.length; i++){
             System.out.println("\"" + fileTempLines[i] + "\"");
        }
        */
        String[] tempLines = new String[fileTempLines.length]; //Some JRE's have trouble with empty lines, so each empty line character gets replace by "$*$"
        for(int i = 1; i < tempLines.length; i++){
            if(fileTempLines[i] == fileTempLines[1]) tempLines[i] = "$*$";
            else tempLines[i] = fileTempLines[i];
        }


        ArrayList<String> singleLines = new ArrayList(); //singleLines store the topic headings (ex. T1A - Name)
        ArrayList<multiLine> multiLines = new ArrayList<>(); //multiLines store the questions in the file format multiLine
        ArrayList<String> sectionLines = new ArrayList<>(); //sectionLines store the SUBELEMENTS
        for(int i = 2; i < tempLines.length - 1; i++){ // Add every single line (including Subelements - they will be seperated later
            if(tempLines[i - 1].equals("$*$") && tempLines[i + 1].equals("$*$") && !tempLines[i].equals("$*$")){ //checks line ebfore and after for empty charcater $*$
                singleLines.add(tempLines[i]);
            }
            if(tempLines[i - 1].equals("$*$") && !tempLines[i].equals("$*$") && !tempLines[i + 1].equals("$*$") && tempLines.length - i > 5){ //Checks for a 'block' of text - if its a block it is a question
                multiLines.add(new multiLine(tempLines[i], tempLines[i + 1], tempLines[i + 2], tempLines[i + 3], tempLines[i + 4], tempLines[i + 5]));
            }
        }
      //  System.out.println("PRINTS:"); //debug purposes
        for(int i = 0; i < singleLines.size(); i++){ //Seperate the SUBELEMENTS from the Section Lines
            if(singleLines.get(i).contains("SUBELEMENT")){
                 sectionLines.add(singleLines.remove(i));
            }
        }

        ArrayList<SubSection> allSections = new ArrayList<>(); //Array Used to store ALL DATA Including Quesions/
        for(int i = 0; i < sectionLines.size(); i++){
            String sectionName = sectionLines.get(i).substring(11, 13);
            String sectionTitle = sectionLines.get(i).substring(16);
            ArrayList<Topic> sectionTopics = new ArrayList<>();
            while(singleLines.size() > 0){
                if(singleLines.get(0).substring(0, 2).equals(sectionName)) {
                    String tempTopic = singleLines.remove(0);
                    String topicName = tempTopic.substring(0, 3);
                    String topicTitle = tempTopic.substring(6);
                    ArrayList<Question> topicQuestions = new ArrayList<>();
                        while (multiLines.size() > 0) {
                            if (multiLines.get(0).getOne().contains(topicName)) {
                                multiLine currentQuestion = multiLines.remove(0);

                                String answer = currentQuestion.getOne().substring(currentQuestion.getOne().indexOf("("));
                                String part97 = "";
                                if (currentQuestion.getOne().indexOf("[") != -1) {
                                    part97 = currentQuestion.getOne().substring(currentQuestion.getOne().indexOf("["));
                                }
                                String question = currentQuestion.getTwo();
                                String a = currentQuestion.getThree();
                                String b = currentQuestion.getFour();
                                String c = currentQuestion.getFive();
                                String d = currentQuestion.getSix();
                                topicQuestions.add(new Question(answer, part97, question, a, b, c, d)); //Add the Question
                            }
                            else break; //End the loop
                        }

                    sectionTopics.add(new Topic(topicName, topicTitle, topicQuestions.size(), topicQuestions));
                }
                else break;
            }
            allSections.add(new SubSection(sectionName, sectionTitle, sectionTopics));
        }


        for(int i = 0; i < allSections.size(); i++){
            System.out.println("SECTION: " + allSections.get(i).getName());
            for(int j = 0; j < allSections.get(i).getTopics().size(); j++){
                System.out.println("  TOPICS: " + allSections.get(i).getTopics().get(j).getName());
                for(int k = 0; k < allSections.get(i).getTopics().get(j).getQuestions().size(); k++){
                    System.out.println("    Q: " + allSections.get(i).getTopics().get(j).getQuestions().get(k).getQuestion());
                }
            }
        }

        /*
           SubSection
                -Topic
                    -Questions
         */
        ArrayList<String> printOut = new ArrayList<>();



        printOut.add("[");
        for(int i = 0; i < allSections.size(); i++){
            printOut.add("   {");
            printOut.add("      \"subsection\": \"" + allSections.get(i).getName() + "\",");
            printOut.add("      \"subsectiontitle\": \"" + allSections.get(i).getTitle() + "\",");
            printOut.add("      \"topics\": [");
            printOut.add("      {");
            for(int j = 0; j < allSections.get(i).getTopics().size(); j++){
                printOut.add("            \"topic\": \"" + allSections.get(i).getTopics().get(j).getName() + "\",");
                printOut.add("            \"topictitle\": \"" + allSections.get(i).getTopics().get(j).getTitle() + "\",");
                printOut.add("            \"topiccount\": " + allSections.get(i).getTopics().size() + ",");
                printOut.add("            \"questions:\": [");
                printOut.add("             {");
                for(int k = 0; k < allSections.get(i).getTopics().get(j).getQuestions().size(); k++){
                    printOut.add("                \"question\": \"" + allSections.get(i).getTopics().get(j).getName() + "\",");

                }
            }

        }

        setFile download = new setFile(DIRECTORY_OF_OUTPUT, printOut);


        System.out.println("Total Memory Used: " + ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() + 500) / 1000) + " KB");
    }
}