package lotto.ui;

import lotto.domain.Lottos;
import lotto.domain.Result;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.\n%s\n";
    private static final String RESULT_FORMAT = "당첨 통계\n---\n%s\n총 수익률은 %.1f%%입니다.";
    private static final String UNEXPECTED_ERROR_MESSAGE = "[ERROR] 예상치 못한 에러로 게임을 종료합니다.";

    private OutputView() {
    }

    public static void printLottos(Lottos lottos) {
        System.out.printf((PURCHASE_MESSAGE) + "%n", lottos.count(), lottos);
    }

    public static void printResult(Result result) {
        System.out.printf((RESULT_FORMAT) + "%n", result, result.yield());
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printUnexpectedErrorMessage() {
        System.out.println(UNEXPECTED_ERROR_MESSAGE);
    }
}
