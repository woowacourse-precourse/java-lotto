package lotto.controller;

import lotto.domain.Payment;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        Payment payment = InputView.inputPayment();
        System.out.println(payment.countOfPurchasedLotto());
    }
}
