package lotto.view;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final String BOUGHT_LOTTO_COUNT = "%d개를 구매했습니다.";
    private static final String LOTTO_WIN_RESULT = "%d개 일치%s (%s원) - %d개";
    private static final String BONUS_WIN = ", 보너스 볼 일치";
    private static final String RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";
    private static final String RESULT_HEADER = "\n당첨 통계\n---";
    private static final String EMPTY_STRING = "";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat("###,###");

    private OutputView() {
    }
    public static void printIssuedLotto(List<List<Integer>> lottos) {
        printLottoCnt(lottos.size());
        printLottos(lottos);
    }

    private static void printLottoCnt(int cnt) {
        System.out.printf("\n" + BOUGHT_LOTTO_COUNT + "\n", cnt);
    }

    private static void printLottos(List<List<Integer>> lottos) {
        lottos.forEach(System.out::println);
    }

}
