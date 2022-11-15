package lotto.controller;

import lotto.model.User;
import lotto.view.LottoPurchaseUI;

public class LottoPurchase {
    private final LottoPurchaseUI lottoPurchaseUI = new LottoPurchaseUI();

    public User controlLottoPurchase(){
        String purchaseAmount = lottoPurchaseUI.takePurchaseAmount();
        User user = new User(purchaseAmount);
        user.createUserLottos();
        lottoPurchaseUI.showLottoNumbers(user.getUserLottos());
        return user;
    }
}
