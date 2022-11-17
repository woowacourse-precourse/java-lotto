package lotto.Constant;

import java.util.function.IntConsumer;
import java.util.function.IntToLongFunction;
import lotto.Constant.Constants.ResultMessage;

public enum Result {
    THREE("3", value -> value * 5_000L,
        count -> System.out.println(ResultMessage.THREE_MATCH + count + ResultMessage.AMOUNT)),
    FOUR("4", value -> value * 50_000L,
        count -> System.out.println(ResultMessage.FOUR_MATCH + count + ResultMessage.AMOUNT)),
    FIVE("5", value -> value * 1_500_000L,
        count -> System.out.println(ResultMessage.FIVE_MATCH + count + ResultMessage.AMOUNT)),
    FIVE_B("5B", value -> value * 30_000_000L,
        count -> System.out.println(ResultMessage.FIVE_B_MATCH + count + ResultMessage.AMOUNT)),
    SIX("6", value -> value * 2_000_000_000L,
        count -> System.out.println(ResultMessage.SIX_MATCH + count + ResultMessage.AMOUNT));

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
