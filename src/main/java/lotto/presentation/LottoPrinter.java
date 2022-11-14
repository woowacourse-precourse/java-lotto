package lotto.presentation;

import lotto.data.LottoRank;
import lotto.data.OutputPrint;
import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

public class LottoPrinter {

    private void printTotalProfit(double profit) {
        String[] prints = OutputPrint.OUTPUT_TOTAL_PROFIT.getMessage().split("/");
        System.out.println(prints[0] + profit + prints[1]);
    }

    public void printLottoCount(int count) {
        System.out.println(count + OutputPrint.OUTPUT_LOTTO_COUNT.getMessage());
    }

    public void printLottoResult(Map<LottoRank, Integer> winningCounts, double profit) {
        printWinningStatistic();

        for (LottoRank lottoRank : LottoRank.getLottoRanksDesc()) {
            int winningAmount = winningCounts.get(lottoRank);
            lottoRank.printLottoRankWithAmount(winningAmount);
        }

        printTotalProfit(profit);
    }

    private void printWinningStatistic() {
        OutputPrint.OUTPUT_WINNING_STATISTIC.printMessage();
        OutputPrint.OUTPUT_BORDER.printMessage();
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }
    }
}
