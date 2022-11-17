package lotto.View;

import java.util.List;
import java.util.Map;
import lotto.Constant.Constants.Message;
import lotto.Constant.Result;
import lotto.Model.Lotto;

public class OutputView {

    private static final float PERCENTAGE = 100.0f;
    private static final String FORMAT = "%.1f";

    public void printMessage(final String message) {
        System.out.println(message);
    }

    public void printLotto(final List<Lotto> number) {
        printMessage("\n" + number.size() + Message.BUY_AMOUNT);
        number.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printResult(final Map<String, Integer> savedResult) {
        printMessage(Message.STATISTICS_MESSAGE);
        for (Result key : Result.values()) {
            key.printResult(savedResult.getOrDefault(key.getMatchNumber(), 0));
        }
    }

    public void printPrizeMoney(final long prizeMoney, final float buyerMoney) {
        final float rate = prizeMoney / buyerMoney * PERCENTAGE;
        printMessage(Message.MONEY_MESSAGE1 + String.format(FORMAT, rate) + Message.MONEY_MESSAGE2);
    }
}
