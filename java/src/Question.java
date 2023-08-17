public class Question {
    private String answer;
    private String part97;
    private String url;
    private String question;
    private String a;
    private String b;
    private String c;
    private String d;

    public Question(String answer, String part97, String question, String a, String b, String c, String d) {

        this.answer = answer;
        this.part97 = part97;
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.url = "Test";
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPart97() {
        return part97;
    }

    public void setPart97(String part97) {
        this.part97 = part97;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}

