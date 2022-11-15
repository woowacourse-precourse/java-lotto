package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

import static lotto.view.printer.OutputPrinter.*;

public class OutputView {
    public static void printUserLottos(List<Lotto> userLottos) {
        printBuyInformMessage(userLottos.size());
        for (Lotto lotto : userLottos) {
            printLottoNumbers(lotto);
        }
    }

    public static void printWinningStatistics(Map<Rank, Integer> userLottoScore, String profitRate) {
        printWinningStatisticsHeader();
        for (int index = 1; index < Rank.values().length; index++) {
            Rank rank = Rank.values()[index];
            printWinningPrize(rank, userLottoScore.get(rank));
        }
        printWinningProfitRate(profitRate);
    }

    public static void printErrorMessage(IllegalArgumentException error){
        System.out.println(error.getMessage());
    }
}