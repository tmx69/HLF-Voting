package Models;

public class Voting {
    private String title;
    private String id;
    private VotingQuestion[] questions;
    private String[] participants;
    private VotingTime time;
    private String pubKey;

    public String getTitle() { return this.title; }
    public String getId() { return this.id; }
    public String getPubKey() { return this.pubKey; }

    public String[] getParticipants() { return this.participants; }
    public VotingQuestion[] getQuestions() { return this.questions; }
    public VotingTime getTime() { return this.time; }
}
