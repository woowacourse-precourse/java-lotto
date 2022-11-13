package lotto;

import ui.View;
import user.User;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        LottoSeller lottoSeller = new LottoSeller();

        lottoSeller.giveLottos(user);
        user.printPurchaseResult();

        lottoSeller.lottoDraw();
        lottoSeller.givePrize(user);

        user.printRatio();
    }
}
