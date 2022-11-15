package lotto.domain;

import lotto.controller.HistoryBuilder;

// 결과에 따라 당첨금을 설정해주는 책임
public class WinningAmount extends HistoryBuilder {

    private int winningAmount;

    public int setWinningAmount() {
        buildMatchCount();

        if (buildMatchCount() == 3) {
            winningAmount = 5000;
        }

        if (buildMatchCount() == 4) {
            winningAmount = 50000;
        }

        if (buildMatchCount() == 5) {
            winningAmount = 1500000;
        }

        if (winningBonus()) {
            winningAmount = 30000000;
        }

        if (buildMatchCount() == 6) {
            winningAmount = 2000000000;
        }

        return winningAmount;
    }

}
