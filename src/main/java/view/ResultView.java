package view;

import domain.Lotto;
import domain.WinLotto;
import util.LottoMessage;

import java.util.List;

public class ResultView {

    public ResultView() {}

    public void displayAllLotteries(List<Lotto> lotteries) {
        System.out.println(String.format(LottoMessage.NUMBER_RESULT, lotteries.size()));
        lotteries.iterator()
                .forEachRemaining(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void displayPercentageProfit(String percentageProfit) {
        System.out.println(percentageProfit);
    }

    public void displayWinStatistics() {
        System.out.println(LottoMessage.WIN_STATISTICS);
    }

    public void displaySeparator() {
        System.out.println(LottoMessage.LINE_SEPARATOR);
    }

    public void displayWinners(WinLotto winLotto) {

    }
}
