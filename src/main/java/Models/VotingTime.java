package Models;

import java.time.LocalDateTime;

public class VotingTime {
    private LocalDateTime votingStart;
    private LocalDateTime votingEnd;
    private LocalDateTime registrationStart;
    private LocalDateTime registrationEnd;

    public void setVotingStart(LocalDateTime time) {this.votingStart = time; }
    public void setVotingEnd(LocalDateTime time) {this.votingEnd = time; }
    public void setRegistrationStart(LocalDateTime time) {this.registrationStart = time; }
    public void setRegistrationEnd(LocalDateTime time) {this.registrationEnd = time; }

    public LocalDateTime getVotingStart() {return this.votingStart; }
    public LocalDateTime getVotingEnd() {return this.votingEnd; }
    public LocalDateTime getRegistrationStart() {return this.registrationStart; }
    public LocalDateTime getRegistrationEnd() {return this.registrationEnd; }
}
