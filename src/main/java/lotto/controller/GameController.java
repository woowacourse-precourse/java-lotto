package lotto.controller;

import lotto.domain.ingame.Lotto;
import lotto.domain.ingame.LottoFactory;
import lotto.domain.ingame.LuckyNumbers;
import lotto.domain.ingame.Payment;
import lotto.domain.result.Statistic;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {
    public void run() {

        try {
            final Payment payment = makePayment();
            final List<Lotto> userLotto = issueLotto(payment.getTicket());
            OutputView.showLotto(userLotto);

            final LuckyNumbers luckyNumbers = makeLuckyNumbers();
            final Statistic statistic = makeStatistic(userLotto,luckyNumbers, payment.getAmount());
            OutputView.showStatistic(statistic);

        } catch (IllegalArgumentException exception) {

            OutputView.showError(exception.getMessage());
        }
    }


    private Payment makePayment() {
        return new Payment(InputView.inputPayment());
    }

    private LuckyNumbers makeLuckyNumbers() {
        return LottoFactory.createLuckyNumbers(InputView.inputLuckyBalls(), InputView.inputBonus());
    }

    private List<Lotto> issueLotto(int tickets) {
        return LottoFactory.createLotto(tickets);
    }

    private Statistic makeStatistic(List<Lotto> userLotto, LuckyNumbers luckyNumbers, int amount) {
        return new Statistic(userLotto,luckyNumbers,amount);
    }


}
