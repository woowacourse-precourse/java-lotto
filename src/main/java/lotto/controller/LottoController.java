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
        LottoTicket lottoTicket = purchaseLottoTicket(amount);
        WinningNumbers winningNumbers = createWinningNumbers();
        LottoResult lottoResult = getLottoResult(lottoTicket, winningNumbers);
        printResult(amount, lottoResult);
    }

    private void printResult(LottoAmount amount, LottoResult lottoResult) {
        printResultIntro();
        printLottoResult(lottoResult);
        printProfit(amount.calculateProfit(lottoResult.calPriceSum()));
    }

    private LottoResult getLottoResult(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        return lottoTicket.calLottoWinResult(winningNumbers);
    }

    private WinningNumbers createWinningNumbers() {
        Lotto inputLottoNumbers = getInputLottoNumbers();
        int bonusNumber = getBonusNumber();

        return getWinningNumbers(inputLottoNumbers, bonusNumber);
    }

    private WinningNumbers getWinningNumbers(Lotto inputLottoNumbers, int bonusNumber) {
        try {
            return new WinningNumbers(inputLottoNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return getWinningNumbers(inputLottoNumbers, getBonusNumber());
        }
    }

    private int getBonusNumber() {
        try {
            return InputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return getBonusNumber();
        }
    }

    private Lotto getInputLottoNumbers() {
        try {
            return new Lotto(inputWinningNumbers());
        } catch (IllegalArgumentException e) {
            printException(e);
            return getInputLottoNumbers();
        }
    }

    private LottoTicket purchaseLottoTicket(LottoAmount amount) {
        int ticketCount = amount.calculateLottoCount();
        printLottoTicketCount(ticketCount);

        LottoTicket lottoTicket = new LottoTicket(ticketCount);
        printTicket(lottoTicket);
        return lottoTicket;
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
