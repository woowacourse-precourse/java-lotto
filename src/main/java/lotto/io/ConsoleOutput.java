package lotto.io;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningStatus;

public class ConsoleOutput implements Output {
    private static final String PURCHASE_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_PROMPT = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "\n보너스 번호를 입력해 주세요.";
    private static final String PURCHASE_TEXT = "개를 구매했습니다.";
    private static final String RESULT_TEXT = "\n당첨통계\n---";
    private static final String ERROR_PREFIX = "[ERROR] ";

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
    public void printResult(WinningStatus winningStatus) {
        System.out.println(RESULT_TEXT);
        System.out.println(winningStatus);
    }

    @Override
    public void printError(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
