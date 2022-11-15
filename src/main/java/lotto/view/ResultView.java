package lotto.view;

import lotto.domain.RandomLotto;
import lotto.domain.Winning;
import lotto.domain.WinningResult;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static java.lang.String.*;

public class ResultView {

    private static final String PRE_SCORE_MESSAGE = "당첨 통계\n---";
    private static final String MONEY_FORMAT = "###,###";
    private static final String SCORE_MESSAGE_FORMAT = "%s (%s원) - %d개";
    private static final String PURCHASE_LOTTO_NUM_FORMAT = "%s개를 구매했습니다.";
    private static final String PROFIT_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.\n";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] ";

    public void showNumberOfLottoPurchase(RandomLotto randomLotto) {
        String format = format(PURCHASE_LOTTO_NUM_FORMAT, randomLotto.getNumberOfLottoGame());
        System.out.println(format);
    }

    public void showAllRandomLottoNumbers(RandomLotto randomLotto) {
        for (List<Integer> list : randomLotto.getRandomLottos()) {
            System.out.println(list);
        }
    }

    public void showWinningResult(WinningResult winningResult) {
        System.out.println(PRE_SCORE_MESSAGE);
        DecimalFormat decimalFormat = new DecimalFormat(MONEY_FORMAT);
        Map<Winning, Integer> winningResultMap = winningResult.getWinningResultMap();

        for (Winning winning : Winning.values()) {
            String format = format(SCORE_MESSAGE_FORMAT,
                    winning.getMatchMessage(),
                    decimalFormat.format(winning.getPrizeMoney()),
                    winningResultMap.get(winning));
            System.out.println(format);
        }
    }

    public void showLottoYield(WinningResult winningResult, int inputAmount) {
        float yield = 0;
        for (Winning winning : Winning.values()) {
            yield += winning.getPrizeMoney() * winningResult.getWinningResultMap().get(winning);
        }
        String format = format(PROFIT_MESSAGE_FORMAT, yield / inputAmount * 100);
        System.out.println(format);
    }

    public void createErrorMessage(IllegalArgumentException exception) {
        System.out.println(ERROR_MESSAGE_FORMAT + exception.getLocalizedMessage());
    }
}
