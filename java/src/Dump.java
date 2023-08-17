public class Dump {
      /*
        //Store each line from temporary array into proper objects.
        ArrayList<Topics> allTopics = new ArrayList<>();

        for(int i = 0; i < tempTopics.size(); i++){
            if(tempTopics.get(i).contains("SUBELEMENT")){ //Topics Identifiable by the word "Subelement"
                ArrayList<String> subTopics = new ArrayList<>();
                for(int j = i + 1; j < tempTopics.size(); j++){ // Search the rest of the subtopics. If "SUBELEMENT" is found, creates new topic
                  if(!tempTopics.get(j).contains("SUBELEMENT")) subTopics.add(tempTopics.get(j));
                  else break;
                }
                allTopics.add(new Topics(tempTopics.get(i), subTopics)); //Store subtopics into new array
            }
        }
        for(Topics printTopics: allTopics){
            System.out.println(printTopics.getTitle());
            System.out.println(printTopics.getSubTopics());
        }
        System.out.println("All Topics Processed");


        //Question Parts

        ArrayList<Question> mainData = new ArrayList<Question>();

        for(int i = 1; i < tempLines.length - 6; i++){
            if(tempLines[i].contains("$*$")){
                boolean isQuestion = true;
                for(int j = 1; j < 5; j++)if(tempLines[i + j].contains("$*$")) isQuestion = false;
                if(isQuestion){
                    String header = tempLines[i + 1];
                    String question = tempLines[i + 2];
                    String answerA = tempLines[i + 3];
                    String answerB = tempLines[i + 4];
                    String answerC = tempLines[i + 5];
                    String answerD = tempLines[i + 6];

                    String section  = header.substring(0, 2);
                    String subSection = header.substring(0, 3);

                    String answer = header.substring(header.indexOf("(") + 1, header.indexOf("(") + 2);
                    String part97 = "";
                    if(header.contains("[")) part97 = header.substring(header.indexOf("[") + 1, header.length() - 1);

                    mainData.add(new Question(section, subSection, answer, part97, question, answerA, answerB, answerC, answerD));
                }

            }
        }

        ArrayList<String> tempData = new ArrayList<>();
        for(Question data: mainData){
            tempData.add(data.getPart97());
        }



        ArrayList<SubSection> allTopics = new ArrayList();
        int pointer = 0;

        for(int i = 1; i < tempLines.length; i++){
            if(tempLines[i].contains("SUBELEMENT")){
                pointer = i;
                break;
            }
        }

        for(int i = 0; i < 10; i++){
            ArrayList<Topic> allQuestions = new ArrayList<>();
            String name = tempLines[pointer].substring(10, 13);
            System.out.println(name);
            String title = tempLines[pointer].substring(14);
            System.out.println(title);
            ArrayList<Question> questionsInTopic = new ArrayList<>();
            String subName = "";
            String subTitle = "";
            for(int j = pointer + 1; j < tempLines.length; j++g){
                System.out.println("J: " + tempLines[j]);
                if(!tempLines[j].contains("$*$")){
                    subName = tempLines[j].substring(0, 3);
                    System.out.println("subame: " + subName);
                    subTitle = tempLines[j].substring(4);
                    for(int k = j + 1; k < tempLines.length; k+= 4){
                        if(!tempLines[k].contains("$*$") && !tempLines[k - 1].contains("$*$") && tempLines[k + 1].contains("$*$")){
                            String header = tempLines[k];
                            String question = tempLines[k + 2];
                            String answerA = tempLines[k + 3];
                            String answerB = tempLines[k + 4];
                            String answerC = tempLines[k + 5];
                            String answerD = tempLines[k + 6];

                            String answer = header.substring(tempLines[k].indexOf("(") + 1, tempLines[k].indexOf("(") + 2);
                            String part97 = "";
                            if(header.contains("[")) part97 = header.substring(header.indexOf("[") + 1, header.length() - 1);

                            questionsInTopic.add(new Question(answer, part97, question, answerA, answerB, answerC, answerD));
                        }
                        else{
                            pointer = k + 1;
                            break;
                        }
                    }

                }
                allQuestions.add(new Topic(subName, subTitle, questionsInTopic.size(), questionsInTopic));
            }
            allTopics.add(new SubSection(name, title, allQuestions));
        }


        ArrayList<String> tempData = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < allTopics.get(i).getTopics().size(); i++){
                for(int k = 0; k < allTopics.get(i).getTopics().get(j).getQuestions().size(); k++){
                    tempData.add(allTopics.get(i).getTopics().get(j).getQuestions().get(k).getA());
                }
            }
        }




  int header = 0;
        int leader = 0;
        for(int i = 0; i < singleLines.size(); i++){
            if(singleLines.get(i).contains("SUBELEMENT")){
                header = i;
                break;
            }
        }

        int questionHeader = 0;

        for(int i = header; i < singleLines.size() - 1; i++){     //All Topics
            String topicName = singleLines.get(i).substring(11, 13);
            String topicTitle = singleLines.get(i).substring(15);
            ArrayList<Topic> tempTopics = new ArrayList<>();

            for(int j = header + 1; j < singleLines.size(); j++){   //All SubSections
                if(!singleLines.get(j).contains("SUBELEMENT")){
                    String sectionName = singleLines.get(j).substring(0, 4);
                    String sectionTitle = singleLines.get(j).substring(5);
                    ArrayList<Question> tempQuestions = new ArrayList<>();


                    String match = multiLines.get(questionHeader).getOne().substring(0, 3);  //all Questions
                    for(int k = questionHeader; k < multiLines.size(); k++){
                        if(multiLines.get(k).getOne().substring(0, 3).equals(match)) {
                            String answer = multiLines.get(k).getOne().substring(multiLines.get(k).getOne().indexOf("("));
                            String part97 = "";
                            if (multiLines.get(k).getOne().indexOf("[") != -1) {
                                part97 = multiLines.get(k).getOne().substring(multiLines.get(k).getOne().indexOf("["));
                            }
                            String question = multiLines.get(k).getTwo();
                            String a = multiLines.get(k).getThree();
                            String b = multiLines.get(k).getFour();
                            String c = multiLines.get(k).getFive();
                            String d = multiLines.get(k).getSix();
                            tempQuestions.add(new Question(answer, part97, question, a, b, c, d)); //Add the Question
                        }
                        else{
                            questionHeader = k + 1;
                            break; //End the Topic
                        }
                    }

                    tempTopics.add(new Topic(sectionName, sectionTitle, tempQuestions.size(), tempQuestions));

                }
                else {
                    header = j;
                    leader = j;
                    break;
                }



            }
            allSections.add(new SubSection(topicName, topicTitle, tempTopics));
            i = leader + 1;

        }
        System.out.println("-----PRINTOUT-----");




            for(int i = 0; i < allSections.size(); i++){
                System.out.println("Topic: " + allSections.get(i).getName());

                for(int j = 0; j < allSections.get(i).getTopics().size(); j++){
                    System.out.println("    Section: " + allSections.get(i).getTopics().get(j).getName());
                    for(int k = 0; k < allSections.get(i).getTopics().get(j).getQuestions().size(); k++){
                        System.out.println("          Question: " + allSections.get(i).getTopics().get(j).getQuestions().get(k).getQuestion());
                    }
                }
            }



        */
}
