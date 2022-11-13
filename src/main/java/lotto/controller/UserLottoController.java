package lotto.controller;

import lotto.service.UserLottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserLottoController {
    private static UserLottoController instance;
    private static UserLottoService userLottoService;

    private UserLottoController() {
    }

    public static UserLottoController getInstance() {
        if (instance == null) {
            instance = new UserLottoController();
            userLottoService = UserLottoService.getInstance();
        }
        return instance;
    }

    public void enterPurchaseAmount() {
        OutputView.printAskPurchaseAmount();
        String purchaseAmount = InputView.input();
        userLottoService.validate(purchaseAmount);
    }


}
