package lotto.domain.score;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.money.Money;

public enum Ranking {
    NOT_WINNING(0L, RankingScore.NOTING, "낙첨"),
    FIFTH_WINNING(5000L, RankingScore.FIFTH_SCORE, "3개 일치"),
    FOURTH_WINNING(50000L, RankingScore.FOURTH_SCORE, "4개 일치"),
    THIRD_WINNING(1_500_000L, RankingScore.THIRD_SCORE, "5개 일치"),
    SECOND_WINNING(30_000_000L, RankingScore.SECOND_SCORE, "5개 일치, 보너스 볼 일치"),
    FIRST_WINNING(2_000_000_000L, RankingScore.FIRST_SCORE, "6개 일치");

    private final Long prize;
    private final RankingScore score;
    private final String result;

    Ranking(final Long rank, final RankingScore score, final String result) {
        this.prize = rank;
        this.score = score;
        this.result = result;
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
        var decimalFormat = new DecimalFormat("###,###");
        var prize = decimalFormat.format(this.prize);

        return String.format("%s (%s원)", result, prize);
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
