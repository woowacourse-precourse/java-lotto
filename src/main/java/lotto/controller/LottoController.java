package lotto.controller;

import lotto.domain.purchaseAmount.PurchaseAmount;

public class LottoController {
    public void run() {
        long purchaseAmount = PurchaseAmount.getPurchaseAmount();
    }
}
