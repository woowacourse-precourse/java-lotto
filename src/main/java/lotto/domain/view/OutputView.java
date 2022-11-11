package lotto.domain.view;

import lotto.domain.lotto.domain.Lotto;
import lotto.domain.lotto.domain.type.OutputResult;
import lotto.global.util.Util;

import java.util.Map;


public class OutputView {
    private static final String BUY_LOTTO = "%d개를 구매했습니다.";
    private static final String INPUT_PRIZE_NUMBERS = "당첨 번호를 입력해 주세요.";
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

    public static void printDividingLine() {
        enter();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    // TODO::
    public static void printResult(Map<String, Integer> result) {
        for (int i = 3; i < 8; i++) {
            String printResult = null;

            isI6SaveBonus1OrElseSaveBonus0(i);
            assert OutputResult.getMessage(i, BONUS) != null;
            String message = OutputResult.getMessage(i, BONUS);

            int proxy = i;
            if (i == 6 || i == 7) {
                proxy -= 1;
            }

            printResult = String.format(message, result.get(String.format(matchCount, proxy)));

            if (result.get(String.format(matchCount, proxy)) == null) {
                printResult = String.format(message, 0);
            }

            System.out.println(printResult);
        }
    }

    private static void isI6SaveBonus1OrElseSaveBonus0(int i) {
        if (i != 6) {
            BONUS = 0;
            matchCount = "일치 개수 %d개";
        }
        if (i == 6) {
            BONUS = 1;
            matchCount = "일치 개수 %d개, 보너스 볼";
        }
    }
}
