package lotto.model;

public enum MatchScore {
    Nothing(""),
    Three("3개 일치 (5,000원)"),
    Four("4개 일치 (50,000원)"),
    Five("5개 일치 (1,500,000원)"),
    FiveAndBonus("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    Six("6개 일치 (2,000,000,000원)");

    private final String score;

    MatchScore(final String score) {this.score=score;}
    public String getScore() { return score;}
}