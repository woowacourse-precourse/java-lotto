package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    public void run() {
        try {
            Money money = new Money(InputView.inputPurchaseAmount());

            LottoTickets lottoTickets = LottoGenerator.generateTickets(money);
            OutputView.printLottoTickets(lottoTickets);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            throw e;
        }
    }
}
