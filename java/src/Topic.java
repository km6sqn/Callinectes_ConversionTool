import java.util.ArrayList;

public class Topic {
   private String name;
   private String title;
   private int length;
   private ArrayList<Question> questions;

    public Topic(String name, String title, int length, ArrayList<Question> questions) {
        this.name = name;
        this.title = title;
        this.length = length;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
}
