package lotto.constants;

public enum RankingInformation {
    FIFTH_PLACE("3개 일치 (5,000원) - ", 3, 5_000),
    FOURTH_PLACE("4개 일치 (50,000원) - ", 4, 50_000),
    THIRD_PLACE("5개 일치 (1,500,000원) - ", 5, 1_500_000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 5, 30_000_000),
    FIRST_PLACE("6개 일치 (2,000,000,000원) - ", 6, 2_000_000_000);

    private final String statisticSentence;
    private final int numberOfMatch;
    private final int amountOfReturn;

    RankingInformation(String sentence, int number, int amount) {
        this.statisticSentence = sentence;
        this.numberOfMatch = number;
        this.amountOfReturn = amount;
    }

    public String getStatisticSentence() {
        return this.statisticSentence;
    }

    public int getNumberOfMatch() {
        return this.numberOfMatch;
    }

    public int getAmountOfReturn() {
        return this.amountOfReturn;
    }
}
