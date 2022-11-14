package lotto.domain.lottomachine.ranking;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Ranking {
    FIRST_PLACE("1등", "6", 2_000_000_000),
    SECOND_PLACE("2등", "5B", 30_000_000),
    THIRD_PLACE("3등", "5", 1_500_000),
    FOURTH_PLACE("4등", "4", 50_000),
    FIFTH_PLACE("5등", "3", 5_000);

    private final String ranking;
    private final String numberOfMatching;
    private final int cash;

    Ranking(String ranking, String numberOfMatching, int cash) {
        this.ranking = ranking;
        this.numberOfMatching = numberOfMatching;
        this.cash = cash;
    }

    public String getRanking() {
        return ranking;
    }

    public String getNumberOfMatching() {
        return numberOfMatching;
    }

    public int getCash() {
        return cash;
    }

    public static Ranking valueOfRanking(String ranking) {
        return Arrays.stream(values())
                .filter(value -> value.ranking.equals(ranking))
                .findAny()
                .orElse(null);
    }

    public String getCashInDecimalFormat() {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(cash);
    }
}
