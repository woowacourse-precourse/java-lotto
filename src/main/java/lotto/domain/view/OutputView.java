package lotto.domain.view;

import lotto.domain.lotto.domain.Lotto;
import lotto.domain.lotto.domain.type.OutputResult;
import lotto.global.util.Util;

import java.util.Map;

import static lotto.domain.view.constant.OutputViewConstants.*;


public class OutputView {
    private static int BONUS = 0;
    private static String matchCount = "일치 개수 %d개";

    public static void printCountByBuyLotto(int lottoCount) {
        System.out.printf((BUY_LOTTO) + "%n", lottoCount);
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void enter() {
        System.out.println();
    }

    public static String printInputPrizeNumbers() {
        enter();
        System.out.println(INPUT_PRIZE_NUMBERS);
        return Util.input();
    }

    // TODO::
    public static void printDividingLine() {
        enter();
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVIDE_LINE);
    }

    // TODO::
    public static void printResult(Map<String, Integer> result) {
        for (int i = 3; i < 8; i++) {
            String printResult = null;
            isI6SaveBonus1OrElseSaveBonus0(i);

            int proxy = getProxyNumber(i);
            String message = createMessage(i);

            printResult = String.format(message, result.get(String.format(matchCount, proxy)));
            if (result.get(String.format(matchCount, proxy)) == null) {
                printResult = String.format(message, 0);
            }
            System.out.println(printResult);
        }
    }

    // TODO::
    private static void isI6SaveBonus1OrElseSaveBonus0(int i) {
        if (i != 6) {
            BONUS = 0;
            matchCount = MATCH_NUMBER_COUNT;
        }
        if (i == 6) {
            BONUS = 1;
            matchCount = MATCH_NUMBER_COUNT_AND_BONUS;
        }
    }

    // TODO::
    private static int getProxyNumber(int i) {
        int proxy = i;
        if (i == 6 || i == 7) {
            proxy -= 1;
        }
        return proxy;
    }

    // TODO::
    private static String createMessage(int i) {
        assert OutputResult.getMessage(i, BONUS) != null;
        return OutputResult.getMessage(i, BONUS);
    }
}
