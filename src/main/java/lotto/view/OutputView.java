package lotto.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import lotto.domain.TotalLotto;
import lotto.domain.WinningResults;
import lotto.util.Calculate;

public class OutputView {

    private static final String BUYING_LOTTO = "%d개를 구매했습니다.";
    private static final String NEXT_LINE = "\n";
    public static final String RESULT_MESSAGE = "당첨 통계";
    public static final String LINE = "---";
    public static final String RATIO_MESSAGE = "총 수익률은 %s%%입니다.";
    public static final int LOTTO_PRICE = 1000;

    public void printMessage(final String message) {
        System.out.println(message);

    }

    public void printBuyingLottos(final TotalLotto totalLotto) {
        System.out.println();
        System.out.printf(BUYING_LOTTO + NEXT_LINE, totalLotto.getLottoCount());
        System.out.println(totalLotto);
    }

    public void printWinningResult(final WinningResults winningResults, final int lottoCount) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        System.out.println(LINE);
        winningResults.getWinningResults()
                .stream()
                .filter(winningResult -> !winningResult.isNothing())
                .forEach(System.out::println);
        System.out.printf(RATIO_MESSAGE, getRatioMessage(winningResults, lottoCount));
    }

    private String getRatioMessage(final WinningResults winningResults, final int lottoCount) {
        double ratio = Calculate.getRatio(winningResults.getTotalWinningPrice(), lottoCount * LOTTO_PRICE);
        NumberFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(ratio);
    }
}
