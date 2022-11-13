package lotto.constants;

public enum RankingInformation {
    FIFTH_PLACE("3개 일치 (5,000원) - ", 3),
    FOURTH_PLACE("4개 일치 (50,000원) - ", 4),
    THIRD_PLACE("5개 일치 (1,500,000원) - ", 5),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 5),
    FIRST_PLACE("6개 일치 (2,000,000,000원) - ", 6);

    private final String statisticSentence;
    private final int numberOfMatch;

    RankingInformation(String sentence, int number) {
        this.statisticSentence = sentence;
        this.numberOfMatch = number;
    }

    public String getStatisticSentence() {
        return this.statisticSentence;
    }

    public int getNumberOfMatch() {
        return this.numberOfMatch;
    }
}
