package lotto.model;

public enum Score {
    STRIKE(1.0),
    BONUS(0.5);

    private double score;
    Score(Double score) {
        this.score = score;
    }

    public Double getScore() {
        return score;
    }
}
