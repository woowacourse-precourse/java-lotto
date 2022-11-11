package lotto.controller;

import lotto.domain.Payment;
import lotto.domain.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        OutputView.printPaymentInputMessage();
        Payment payment = InputView.inputPayment();
        WinningLottoNumbers winningLottoNumbers = InputView.inputWinningLottoNumbers();
        System.out.println(winningLottoNumbers);
    }
}
