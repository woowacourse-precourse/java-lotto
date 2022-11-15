package lotto.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Ranking {
    rank5(3, "3개 일치 (5,000원)", 5_000),
    rank4(4, "4개 일치 (50,000원)", 50_000),
    rank3(5, "5개 일치 (1,500,000원)", 1_500_000),
    rank2(5.5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    rank1(6, "6개 일치 (2,000,000,000원)", 2_000_000_000);

    final private static Map<Double, Ranking> BY_COUNT =
            Stream.of(values()).collect(Collectors.toMap(Ranking::count, Function.identity()));
    final private double count;
    final private String description;
    final private int money;

    Ranking(double count, String description, int money) {
        this.count = count;
        this.description = description;
        this.money = money;
    }

    public double count() {
        return count;
    }

    public String description() {
        return description;
    }

    public int money() {
        return money;
    }

    public static Ranking valueOfNumber(double count) {
        return BY_COUNT.get(count);
    }

}
