public class Question {
    public String question;
    public Boolean answer;
    public Question(String question, Boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return answer == true ? "Igaz" : "Hamis";
    }
}
