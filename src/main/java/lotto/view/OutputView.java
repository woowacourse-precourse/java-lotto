package lotto.view;

public interface OutputView {
    void printGeneratedLottery(Integer purchaseAmount, String LotteryInfo);

    void printWinningHistory();

    void printProfitRatio(Integer purchaseAmount);

    void printAskPurchaseAmountMessage();

    void printAskWinningNumbersMessage();

    void printAskBonusNumberMessage();
}
