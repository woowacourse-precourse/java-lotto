package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.OutputView.printException;
import static lotto.view.OutputView.printLottoResult;
import static lotto.view.OutputView.printLottoTicketCount;
import static lotto.view.OutputView.printProfit;
import static lotto.view.OutputView.printResultIntro;

public class LottoController {
    public void LottoStart(){
        LottoAmount amount = inputAmount();
    }
    private LottoAmount inputAmount() {
        try {
            return new LottoAmount(InputView.inputAmount());
        } catch (IllegalArgumentException e) {
            printException(e);
            return inputAmount();
        }
    }
}
