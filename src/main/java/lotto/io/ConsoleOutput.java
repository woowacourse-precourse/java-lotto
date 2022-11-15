package lotto.io;

import java.util.List;
import lotto.model.Lotto;

public class ConsoleOutput implements Output {
    private static final String PURCHASE_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_PROMPT = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "\n보너스 번호를 입력해 주세요.";
    private static final String PURCHASE_TEXT = "개를 구매했습니다.";
    private static final String RESULT_TEXT = "\n당첨통계\n---";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String RESULT_FORMAT = "3개 일치 (5,000원) - %d개\n"
            + "4개 일치 (50,000원) - %d개\n"
            + "5개 일치 (1,500,000원) - %d개\n"
            + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
            + "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String YIELD_FORMAT = "총 수익률은 %.1f%%입니다.";

    @Override
    public void printPurchasePrompt() {
        System.out.println(PURCHASE_PROMPT);
    }

    @Override
    public void printWinningNumberPrompt() {
        System.out.println(WINNING_NUMBER_PROMPT);
    }

    @Override
    public void printBonusNumberPrompt() {
        System.out.println(BONUS_NUMBER_PROMPT);
    }

    @Override
    public void printLottos(int count, List<Lotto> lottos) {
        System.out.println("\n" + count + PURCHASE_TEXT);

        lottos.forEach(System.out::println);
    }

    @Override
    public void printResult(List<Integer> winningCounts, double yield) {
        String winningResult = String.format(RESULT_FORMAT, winningCounts.toArray());
        String yieldResult = String.format(YIELD_FORMAT, yield);
        System.out.println(RESULT_TEXT + winningResult + yieldResult);
    }

    @Override
    public void printError(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
