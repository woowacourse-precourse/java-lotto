package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void init() {
        purchaseLotto();
        // generateRandomNumbers();
        // compareLottoNumbers();
        // createStatistic();
    }

    private int purchaseLotto() {
        int inputNumber = InputView.getInputMoney();
        OutputView.printNumberofLotto(inputNumber);

        return inputNumber;
    }
}
