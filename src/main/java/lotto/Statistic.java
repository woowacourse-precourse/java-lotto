package lotto;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Statistic {
    THREE(3, 5_000,"3개 일치 (5,000원)"),
    FOUR(4, 50_000,"4개 일치 (50,000원)"),
    FIVE(5, 1_500_000, "5개 일치 (1,500,000원)"),
    BONUS(7, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(6, 2_000_000_000,"6개 일치 (2,000,000,000원)");

    private final int matchingNumbers;
    private final int prize;
    private final String ment;


    private static final Map<Integer, String> CODE_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Statistic::getMatchingNumbers, Statistic::name)));

            //Collectors.toMap(Statistic::getMatchingNumbers, Statistic::name));
    Statistic(int matchingNumbers, int prize, String ment) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
        this.ment = ment;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrize() {
        return prize;
    }

    public String getMent() {
        return ment;
    }

    public static Statistic of(final int matchingNumbers){
        return Statistic.valueOf(CODE_MAP.get(matchingNumbers));
    }
}
