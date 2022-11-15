package lotto.View;

import java.util.List;
import java.util.Map;
import lotto.Constant.Message;
import lotto.Constant.Result;
import lotto.Model.Lotto;

public class OutputView {

    private static final float PERCENTAGE = 100.0f;
    private static final String ENTER = "\n";
    private static final String STATISTICS_MESSAGE1 = "당첨 통계";
    private static final String STATISTICS_MESSAGE2 = "---";
    private static final String MONEY_MESSAGE1 = "총 수익률은 ";
    private static final String FORMAT = "%.1f";
    private static final String MONEY_MESSAGE2 = "%입니다.";

    public void printMessage(final String message) {
        System.out.println(message);
    }

    public void printLotto(final List<Lotto> number) {
        printMessage(ENTER + number.size() + Message.BUY_AMOUNT.getMessage());
        number.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printResult(final Map<String, Integer> savedResult) {
        printMessage(ENTER + STATISTICS_MESSAGE1 + ENTER + STATISTICS_MESSAGE2);
        for (Result key : Result.values()) {
            key.printResult(savedResult.getOrDefault(key.getMatchNumber(), 0));
        }
    }

    public void printPrizeMoney(final long prizeMoney, final float buyerMoney) {
        final float rate = prizeMoney / buyerMoney * PERCENTAGE;
        printMessage(MONEY_MESSAGE1 + String.format(FORMAT, rate) + MONEY_MESSAGE2);
    }
}
