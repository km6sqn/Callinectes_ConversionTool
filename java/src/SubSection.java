import java.util.ArrayList;

public class SubSection {
    private String name;
    private String title;
    private ArrayList<Topic> topics;

    public SubSection(String name, String title, ArrayList<Topic> topics) {
        this.name = name;
        this.title = title;
        this.topics = topics;
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

    public ArrayList<Topic> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<Topic> topics) {
        this.topics = topics;
    }
}
