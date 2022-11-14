package lotto;

import lotto.View.InputView;
import lotto.View.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LotteryMachine lotteryMachine = new LotteryMachine();
        WinningStat winningStat;

        lotteryMachine.buyLottos(inputView.getAmount());
        outputView.printList(lotteryMachine.getLists());
        winningStat = lotteryMachine.compareNumbers(inputView.getLottoNumber(), inputView.getBonusNumber());

    }
}
