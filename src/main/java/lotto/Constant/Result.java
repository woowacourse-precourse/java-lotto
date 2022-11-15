package lotto.Constant;

import java.util.function.IntConsumer;
import java.util.function.IntToLongFunction;

public enum Result {
    THREE("3", value -> value * 5_000L,
        count -> System.out.println("3개 일치 (5,000원) - " + count + "개")),
    FOUR("4", value -> value * 50_000L,
        count -> System.out.println("4개 일치 (50,000원) - " + count + "개")),
    FIVE("5", value -> value * 1_500_000L,
        count -> System.out.println("5개 일치 (1,500,000원) - " + count + "개")),
    FIVE_B("5B", value -> value * 30_000_000L,
        count -> System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개")),
    SIX("6", value -> value * 2_000_000_000L,
        count -> System.out.println("6개 일치 (2,000,000,000원) - " + count + "개"));

    private final String matchNumber;
    private final IntToLongFunction countingMoney;
    private final IntConsumer print;

    Result(String matchNumber, IntToLongFunction countingMoney, IntConsumer print) {
        this.matchNumber = matchNumber;
        this.countingMoney = countingMoney;
        this.print = print;
    }

    public String getMatchNumber() {
        return matchNumber;
    }

    public long calculrate(int value) {
        return countingMoney.applyAsLong(value);
    }

    public void printResult(int count) {
        print.accept(count);
    }
}
