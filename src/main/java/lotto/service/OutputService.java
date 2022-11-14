package lotto.service;

import java.util.List;
import lotto.entity.Lotto;
import lotto.entity.Result;

public class OutputService {

    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String RESULT_STATUS_MESSAGE = "당첨 통계";
    private static final String LINE = "---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String ERROR_PREFIX = "[ERROR] ";

    private OutputService() {
    }

    public static void printGeneratedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.printf((PURCHASE_MESSAGE) + "%n", lottos.size());
        lottos.forEach(System.out::println);
    }

    public static void printResult(Result result) {
        System.out.println();
        System.out.println(RESULT_STATUS_MESSAGE);
        System.out.println(LINE);
        System.out.println(result);
    }

    public static void printRateOfReturn(Double rate) {
        System.out.printf((RATE_OF_RETURN_MESSAGE) + "%n", rate);
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

}
