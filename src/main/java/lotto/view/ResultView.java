package lotto.view;

import lotto.domain.RandomLotto;
import lotto.domain.Winning;
import lotto.domain.WinningResult;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";
    private static final String PRE_SCORE_MESSAGE = "당첨 통계\n" +
            "---";
    private static final String MONEY_FORMAT = "###,###";
    private static final String SCORE_MESSAGE_FORMAT = "%s (%s원) - %d개";
    private static final String PURCHASE_LOTTO_NUM_FORMAT = "%s개를 구매했습니다.";
    private static final String PROFIT_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.\n";


    public void showNumberOfLottoPurchase(RandomLotto randomLotto) {
        String format = String.format(PURCHASE_LOTTO_NUM_FORMAT, randomLotto.getNumberOfLottoGame());
        System.out.println(format);
    }

    public void showAllRandomLottoNumbers(RandomLotto randomLotto) {
        for (List<Integer> list : randomLotto.getRandomLottoNumbers()) {
            System.out.println(list);
        }
    }

    public void showWinningResult(WinningResult winningResult) {
        System.out.println(PRE_SCORE_MESSAGE);
        DecimalFormat decimalFormat = new DecimalFormat(MONEY_FORMAT);

        for (Map.Entry<Winning, Integer> winningIntegerEntry : winningResult.getWinningResultMap().entrySet()) {
            Winning key = winningIntegerEntry.getKey();
            String format = String.format(SCORE_MESSAGE_FORMAT,
                    key.getMatchMessage(),
                    decimalFormat.format(key.getPrizeMoney()),
                    winningIntegerEntry.getValue());
            System.out.println(format);
        }
    }


}
