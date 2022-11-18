package lotto;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PrizeNumber {
    THREE      ("3개 일치 (5,000원)", 5000),
    FOUR       ("4개 일치 (50,000원)",  50000),
    FIVE       ("5개 일치 (1,500,000원)", 1500000),
    FIVE_BONUS ("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    SIX        ("6개 일치 (2,000,000,000원)", 2000000000);
    private final String prizeString;
    private final int prize;
    PrizeNumber(String prizeString, int prize) {
        this.prizeString = prizeString;
        this.prize = prize;
    }

    public String prizeString() {
        return this.prizeString;
    }

    public int prize() { return this.prize; }
    private static final Map<Integer, PrizeNumber> BY_NUMBERS =
            Stream.of(values()).collect(Collectors.toMap(PrizeNumber::ordinal, Function.identity()));

    public static PrizeNumber getSameNumber(int sameNumber) {
        return BY_NUMBERS.get(sameNumber);
    }
}
