package lotto.model.resources;

import java.util.ArrayList;
import java.util.Map;

import lotto.model.computer.LottoComputer;

import lotto.view.View;
import lotto.view.Message;

public class TotalStat {

    private static final int PERCENTAGE = 100;

    private final Map<Integer, Integer> winnerResult;

    private TotalStat(Map<Integer, Integer> winnerResult) {
        this.winnerResult = winnerResult;
    }

    public static TotalStat of(TotalWinningLotto totalWinningLotto, LottoComputer lottoComputer) {
        return new TotalStat(
                lottoComputer.lottoCount(totalWinningLotto.getWinningLotto(), totalWinningLotto.getBonusLotto()));
    }

    public long sumWinnersPrices() {
        long sum = 0L;
        for (int i = winnerResult.size() - 1; i >= 0; i--) {
            sum += winnerResult.get(i) * Rank.getPrice(i);
        }
        return sum;
    }

    public void printWinner(View io) {
        for (String statOut : Message.printStat(winnerResult, new ArrayList<>())) {
            io.print(statOut);
        }
    }

    public double resultPercent(LottoComputer lottoComputer) {
        double divider = (double) lottoComputer.getMoney();
        if (divider == 0) {
            return 0;
        }
        return sumWinnersPrices() / divider * PERCENTAGE;
    }

    public void printResultPercent(View io, LottoComputer lottoComputer) {
        io.print(Message.printPercent(resultPercent(lottoComputer)));
    }
}
