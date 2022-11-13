package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Player;
import lotto.model.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ApplicationController {
    InputView inputView = new InputView();

    public void startApplication() {
        System.out.println("TEST:" + inputView.inputPurchaseAmount()); // TEMP: Validator 구현 후 수정
    }
}
