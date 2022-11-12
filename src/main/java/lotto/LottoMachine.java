package lotto;

import view.InputView;

public class LottoMachine {

    public int CalculateLottoCount() {
        InputView inputView = new InputView();
        int money = inputView.inputMoney();
        int lottoCount = money / 1000;
        return lottoCount;
    }
}
