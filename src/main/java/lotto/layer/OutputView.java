package lotto.layer;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class OutputView extends View {

    private static final String COMPLETE_BUY_LOTTO = "%d개를 구매했습니다.";
    private static final String STATISTICS = "당첨 통계";
    private static final String THREE_DOT_LINE = "---";
    private static final String WINNING_LOTTO_INFO = "%d개 일치 (%s원) - %d개";
    private static final String WINNING_LOTTO_BONUS_INFO = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String BENEFIT_RATE = "총 수익률은 %.1f%%입니다.";

    public void responseBuyLotto(List<Lotto> lotteries) {
        int size = lotteries.size();
        print(String.format(COMPLETE_BUY_LOTTO, size));
        for (Lotto lotto : lotteries) {
            print(lotto.toString());
        }
        printEmptyLine();
    }

    public void responseStatistic(Map<WinningLotto, Integer> frequency, double benefitRate) {
        print(STATISTICS);
        print(THREE_DOT_LINE);
        for (Entry<WinningLotto, Integer> winningLottoEntry : frequency.entrySet()) {
            printWinningLottoInfo(winningLottoEntry);
        }
        print(String.format(BENEFIT_RATE, benefitRate));
    }

    private void printWinningLottoInfo(Entry<WinningLotto, Integer> winningLottoEntry) {
        WinningLotto winningLotto = winningLottoEntry.getKey();
        int count = winningLottoEntry.getValue();
        int commonMatch = winningLotto.getCommonMatch();
        int money = winningLotto.getMoneyValue();
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String moneyFormat = decimalFormat.format(money);
        if (winningLotto.equals(WinningLotto.PLACE_2)) {
            print(String.format(WINNING_LOTTO_BONUS_INFO, commonMatch, moneyFormat, count));
            return;
        }
        print(String.format(WINNING_LOTTO_INFO, commonMatch, moneyFormat, count));
    }
}
