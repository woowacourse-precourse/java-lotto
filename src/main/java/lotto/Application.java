package lotto;

import lotto.View.InputView;
import lotto.View.OutputView;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LotteryMachine lotteryMachine = new LotteryMachine();
        try {
            int amount = inputView.getAmount();
            lotteryMachine.buyLottos(amount);
            outputView.printList(lotteryMachine.getLists());
            lotteryMachine.putWinningNumbers(inputView.getLottoNumber(), inputView.getBonusNumber());
            WinningStat winningStat = lotteryMachine.getWinningStat();
            outputView.printStats(winningStat);
            outputView.printYield(winningStat.yield(amount));
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
        }
    }
}