package lotto.constant;

public enum Rank {
    FIRST(6, 2000000000, "2,000,000,000원"),
    SECOND(5, 30000000, "30,000,000원"),
    THIRD(5, 1500000, "1,500,000원"),
    FOURTH(4, 50000, "50,000원"),
    FIFTH(3, 5000, "5,000원"),
    NONE(0, 0, "0원");

    private final Integer correct;
    private final Integer prize;
    private final String prizeWon;
    
    Rank(int correct, int prize, String prizeWon) {
        this.correct = correct;
        this.prize = prize;
        this.prizeWon = prizeWon;
    }

    public Integer getCorrect() {
        return this.correct;
    }
    
    public Integer getPrize() {
        return this.prize;
    }
    
    public String getPrizeWon() {
        return this.prizeWon;
    }
}