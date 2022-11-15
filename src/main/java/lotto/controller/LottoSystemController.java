package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.cashier.Cashier;
import lotto.domain.lotto.lotto.Lotto;
import lotto.domain.lotto.lottocompany.LottoCompany;
import lotto.domain.lotto.lottocompany.Win;
import lotto.utils.message.OutputMessage;
import lotto.view.input.Input;
import lotto.view.output.Output;

public class LottoSystemController {

    private final Input input;
    private final Output output;
    private final Cashier cashier;
    private final LottoCompany lottoCompany;

    public LottoSystemController(Input input, Output output, Cashier cashier, LottoCompany lottoCompany) {
        this.input = input;
        this.output = output;
        this.cashier = cashier;
        this.lottoCompany = lottoCompany;
    }

    public void runLottoSystem() {
        try {
            int paymentAmount = requestPaymentAmount();
            List<Lotto> publishedLotto = requestPublishNLotto(paymentAmount);
            List<String> winningNumbers = requestInputWinningNumbers();
            int bonusNumber = requestBonusNumber();

            requestFinalStatistic(publishedLotto, winningNumbers, bonusNumber, paymentAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int requestPaymentAmount() throws IllegalArgumentException {
        output.printMessage(OutputMessage.REQUEST_PAYMENT_AMOUNT);
        return input.inputPaymentAmount();
    }

    private List<Lotto> requestPublishNLotto(int paymentAmount) {
        int publishLottoCount = cashier.checkPublishLottoCount(paymentAmount);
        List<Lotto> publishedLotto = lottoCompany.publishNLotto(publishLottoCount);
        output.printPublishedLotto(publishedLotto);
        return publishedLotto;
    }

    private List<String> requestInputWinningNumbers() throws IllegalArgumentException {
        output.printMessage(OutputMessage.REQUEST_WINNING_NUMBER);
        return input.inputWinningNumbers();
    }

    private int requestBonusNumber() throws IllegalArgumentException{
        output.printMessage(OutputMessage.REQUEST_BONUS_NUMBER);
        return input.inputBonusNumber();
    }

    private void requestFinalStatistic(List<Lotto> publishedLotto, List<String> winningNumbers,
                                       int bonusNumber, int paymentAmount) {
        Map<Win, Integer> winResult = lottoCompany.makeWinResult(publishedLotto, winningNumbers, bonusNumber);
        double rateOfReturn = cashier.calculateRateOfReturn(paymentAmount, lottoCompany.getTotalPrize());

        output.printLottoResult(winResult, rateOfReturn);
    }
}
