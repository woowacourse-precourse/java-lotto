package lotto.view;

import lotto.domain.Lottery;

public interface OutputView {
    void printGeneratedLottery(Lottery lottery);

    void printWinningHistory();

    void printProfitRatio();

    void printAskPurchaseAmountMessage();

    void printAskWinningNumbersMessage();

    void printAskBonusNumberMessage();
}
