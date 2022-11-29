package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Prize {
    THREE_STRIKE(3.0, "3개 일치 (5,000원)",  5_000),
    FOUR_STRIKE(4.0, "4개 일치 (50,000원)",  50_000),
    FIVE_STRIKE(5.0, "5개 일치 (1,500,000원)", 1_500_000),
    FIVE_STRIKE_WITH_BONUS(5.5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    SIX_STRIKE(6.0, "6개 일치 (2,000,000,000원)",  2_000_000_000);

    private Double prize;
    private String message;
    private Integer money;

    Prize(Double prize, String message, Integer money) {
        this.prize = prize;
        this.message = message;
        this.money = money;
    }

    public Integer calculate(int count) {
        return money * count;
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