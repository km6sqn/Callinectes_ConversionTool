import java.util.ArrayList;
public class Topics {
    private String title;
    private ArrayList<String> subTopics;
    public Topics(String title, ArrayList<String> subTopics){
        this.title = title;
        this.subTopics = subTopics;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getSubTopics() {
        return subTopics;
    }

    public void setSubTopics(ArrayList<String> subTopics) {
        this.subTopics = subTopics;
    }
}
