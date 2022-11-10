package lotto.domain.view;

import lotto.domain.lotto.domain.Lotto;
import lotto.global.util.Util;

import java.util.Map;


public class OutputView {
    private static final String BUY_LOTTO = "%d개를 구매했습니다.";
    private static final String INPUT_PRIZE_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String MATCH_NUMBER_THREE = "3개 일치 (5,000) - %d개";
    private static final String MATCH_NUMBER_FOUR = "4개 일치 (50,000원) - %d개";
    private static final String MATCH_NUMBER_FIVE = "5개 일치 (1,500,000원) - %d개";
    private static final String MATCH_NUMBER_FIVE_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String MATCH_NUMBER_SIX = "6개 일치 (2,000,000,000원) - %d개";

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

    public static void printResult(Map<String, Integer> result) {
        String printResult = null;

        printResult = String.format(MATCH_NUMBER_THREE, result.get("3개 일치 개수"));
        if (result.get("3개 일치 개수") == null) {
            printResult = String.format(MATCH_NUMBER_THREE, 0);
        }
        System.out.println(printResult);

        printResult = String.format(MATCH_NUMBER_FOUR, result.get("4개 일치 개수"));
        if (result.get("4개 일치 개수") == null) {
            printResult = String.format(MATCH_NUMBER_FOUR, 0);
        }
        System.out.println(printResult);

        printResult = String.format(MATCH_NUMBER_FIVE, result.get("5개 일치 개수"));
        if (result.get("5개 일치 개수") == null) {
            printResult = String.format(MATCH_NUMBER_FIVE, 0);
        }
        System.out.println(printResult);

        printResult = String.format(MATCH_NUMBER_FIVE_BONUS, result.get("5개 일치 개수, 보너스 볼 일치 개수"));
        if (result.get("5개 일치 개수, 보너스 볼 일치 개수") == null) {
            printResult = String.format(MATCH_NUMBER_FIVE_BONUS, 0);
        }
        System.out.println(printResult);

        printResult = String.format(MATCH_NUMBER_SIX, result.get("6개 일치 개수"));
        if (result.get("6개 일치 개수") == null) {
            printResult = String.format(MATCH_NUMBER_SIX, 0);
        }
        System.out.println(printResult);
    }
}
