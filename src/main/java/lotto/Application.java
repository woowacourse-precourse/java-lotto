package lotto;

import ui.View;
import user.User;

public class Application {
    public static void main(String[] args) {
        try {
            User user = new User();
            LottoSeller lottoSeller = new LottoSeller();

            lottoSeller.giveLottos(user);

            View.printPurchaseMount(user);
            View.printLottoList(user);

            lottoSeller.lottoDraw();
            lottoSeller.givePrize(user);

            View.printTotalPrize(user);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
