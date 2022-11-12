package lotto.controller;

import lotto.domain.PurchaseMoney;
import lotto.view.Input;

import static lotto.view.Input.*;
import static lotto.view.Output.*;

public class LottoController {

    public void start() {
        try {
            PurchaseMoney purchaseMoney = new PurchaseMoney(insertPurchaseMoney());
        } catch (IllegalArgumentException error) {
            printErrorMessage(error.getMessage());
        }
    }
}
