package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Player;
import lotto.model.Seller;
import lotto.model.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ApplicationController {
    Seller seller = new Seller();
    Player player = new Player();
    Validator validator = new Validator();
    InputView inputView = new InputView();

    public void startApplication() {
        int purchaseAmount = validator.convertStringIntoInt(inputView.inputPurchaseAmount());
        player.setPurchaseAmount(purchaseAmount);
        if (validator.isPurchaseAmountValidate(player.getPurchaseAmount())) {
            // TODO: 로또 발행 과정 제어 기능 호출
        }
    }
}
