package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Prize {
    THREE_STRIKE(3.0, "3개 일치 (5,000원)", resultCount -> resultCount * 5000),
    FOUR_STRIKE(4.0, "4개 일치 (50,000원)", resultCount -> resultCount * 50000),
    FIVE_STRIKE(5.0, "5개 일치 (1,500,000원)", resultCount -> resultCount * 1500000),
    FIVE_STRIKE_WITH_BONUS(5.5, "5개 일치, 보너스 볼 일치 (30,000,000원)", resultCount -> resultCount * 30000000),
    SIX_STRIKE(6.0, "6개 일치 (2,000,000,000원)", resultCount -> resultCount * 2000000000);

    private Double prize;
    private String message;
    private Function<Integer, Integer> expression;

    Prize(Double prize, String message, Function<Integer, Integer> expression) {
        this.prize = prize;
        this.message = message;
        this.expression = expression;
    }

    public Integer calculate(int count) {
        return expression.apply(count);
    }

    public static Prize getPrizeByScore(Double score) {
        return Arrays.stream(values())
                .filter(value -> score.equals(value.prize))
                .findAny()
                .orElse(null);
    }

    public static List<Double> getPrizeCandidates() {
        List<Double> counts = Stream.of(Prize.values())
                .map(Prize::getPrize)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return counts;
    }

    public Double getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}