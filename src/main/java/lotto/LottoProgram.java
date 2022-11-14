package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoProgram {
    private final int LOTTO_PRICE = 1000;

    public void progress() {
        int numberOfLotto = buyLotto();
    }

    private int buyLotto() {
        OutputView.printInputMoneyMessage();

        String input = InputView.getMoney();
        int money = Integer.parseInt(input);
        int numberOfLotto = countLottoQuantity(money);

        OutputView.printNumberOfLottoMessage(numberOfLotto);

        return numberOfLotto;
    }

    public int countLottoQuantity(int money) {
        return money / LOTTO_PRICE;
    }

}
