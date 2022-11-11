package lotto.controller;

import lotto.domain.Payment;
import lotto.domain.WinningLottoNumbers;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        Payment payment = InputView.inputPayment();
        WinningLottoNumbers winningLottoNumbers = InputView.inputWinningLottoNumbers();
        System.out.println(winningLottoNumbers);
    }
}
