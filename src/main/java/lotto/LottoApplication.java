package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoSummary;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoApplication {

    public void run() {
        try {
            Money money = new Money(InputView.inputPurchaseAmount());

            LottoTickets lottoTickets = LottoGenerator.generateTickets(money);
            OutputView.printLottoTickets(lottoTickets);

            List<Integer> winningNumbers = InputView.inputWinningNumbers();
            int bonusNumber = InputView.inputBonusNumber();
            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

            List<Rank> ranks = lottoTickets.getLottos().stream()
                    .map(winningLotto::match)
                    .collect(Collectors.toList());
            LottoSummary summary = new LottoSummary(ranks, money);
            OutputView.printSummary(summary);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            throw e;
        }
    }
}
