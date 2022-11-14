package lotto.controller;

import lotto.model.User;
import lotto.view.LottoPurchaseUI;

public class LottoPurchase {
    private final LottoPurchaseUI lottoPurchaseUI = new LottoPurchaseUI();

    public void controlLottoPurchase(){
        String purchaseAmount = lottoPurchaseUI.takePurchaseAmount();
        User user = new User(purchaseAmount);
        user.createUserLottos();

    }
}
