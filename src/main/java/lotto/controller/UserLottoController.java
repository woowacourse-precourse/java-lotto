package lotto.controller;

import lotto.service.UserLottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserLottoController {
    private static UserLottoController instance;
    private static UserLottoService userLottoService;

    private UserLottoController() {
        userLottoService = UserLottoService.getInstance();
    }

    public static UserLottoController getInstance() {
        if (instance == null) {
            instance = new UserLottoController();
        }
        return instance;
    }

    public void enterPurchaseAmount() {
        OutputView.printAskPurchaseAmount();
        String purchaseAmount = InputView.input();
        userLottoService.validate(purchaseAmount);
        userLottoService.issueLotto(Long.parseLong(purchaseAmount));
    }

    public void printIssuedLotteries() {
        OutputView.printIssuedLotteries(userLottoService.getLotteries());
    }


}
