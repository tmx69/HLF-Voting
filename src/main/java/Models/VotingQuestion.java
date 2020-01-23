package Models;

public class VotingQuestion {
    private String title;
    private VotingAnswer[] answers;

    public VotingQuestion(String title) { this.title = title; }

    public String getTitle() { return this.title; }
    public VotingAnswer[] getAnswers() { return this.answers; }
}
