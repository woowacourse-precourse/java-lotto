package lotto.domain;// @ author ninaaano

import lotto.view.InputView;
import lotto.view.WinningResult;

import java.util.Map;
import java.util.Map.Entry;

public class WinningRate {
    private final int principal;
    private double profits;

    public WinningRate(int principal, Map<String, Integer> totalPrize) {
        this.principal = principal;
        getPrizeMoney(totalPrize);
    }

    private void getPrizeMoney(Map<String, Integer> totalPrize) {
        for (Entry<String, Integer> entry : totalPrize.entrySet()) {
            int prizeMoney = WinningResult.valueOf(entry.getKey()).getWinnings();
            profits += prizeMoney * entry.getValue();
        }
    }

    public double getProfitRate() {
        return Math.round(((profits * 100) / principal) * 10) / 10.0;
    }

    public void printTotalPrize(Map<String, Integer> totalPrize) {
        InputView.LINES.getMessage();
        InputView.WINNING_MESSAGE.getMessage();
        InputView.YIELD_MESSAGE.getMessage();

        for (WinningResult value : WinningResult.values()) {
            System.out.print(value.getResult());
            System.out.println(totalPrize.get(value.name()) + "개");
        }
    }

    public void printProfitRate(double yield) {
        System.out.println(yield + InputView.YIELD_MESSAGE.getMessage());
    }
}
