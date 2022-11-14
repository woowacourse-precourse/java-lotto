package lotto.domain.score;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.money.Money;

public enum Ranking {
    NOT_WINNING(0L, RankingScore.NOTING),
    FIFTH_WINNING(5000L, RankingScore.FIFTH_SCORE),
    FOURTH_WINNING(50000L, RankingScore.FOURTH_SCORE),
    THIRD_WINNING(1_500_000L, RankingScore.THIRD_SCORE),
    SECOND_WINNING(30_000_000L, RankingScore.SECOND_SCORE),
    FIRST_WINNING(2_000_000_000L, RankingScore.FIRST_SCORE);

    private static final String DECIMAL_FORMAT_STRING = "###,###";
    private static final String MESSAGE_RESULT_PRIZE = "%s (%s원)";
    private final Long prize;
    private final RankingScore score;

    Ranking(final Long rank, final RankingScore score) {
        this.prize = rank;
        this.score = score;
    }

    public static Ranking calculateScore(Score score) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.hasScore(score))
                .findAny()
                .orElse(NOT_WINNING);
    }

    public static Map<Ranking, Integer> generateList() {
        return Arrays.stream(Ranking.values())
                .filter(Ranking::isNotNothing)
                .collect(Collectors.toMap(ranking -> ranking, (ranking -> 0), (x, y) -> y, LinkedHashMap::new));
    }

    public String result() {
        var decimalFormat = new DecimalFormat(DECIMAL_FORMAT_STRING);
        var prize = decimalFormat.format(this.prize);

        return String.format(MESSAGE_RESULT_PRIZE, score.resultMatch(), prize);
    }

    public Money calculateProfits(Integer value) {
        return Money.generateMoney(prize * value);
    }

    private boolean isNotNothing() {
        return !score.equals(RankingScore.NOTING);
    }

    private boolean hasScore(Score score) {
        return this.score.contains(score);
    }


}
