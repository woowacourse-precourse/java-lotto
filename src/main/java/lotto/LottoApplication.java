package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResultSummary;
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
            LottoTickets lottoTickets = buyLottoTickets(money);

            WinningLotto winningLotto = getWinningLotto();
            List<Rank> ranks = match(lottoTickets, winningLotto);

            summaryLotto(money, ranks);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private LottoTickets buyLottoTickets(Money money) {
        LottoTickets lottoTickets = LottoGenerator.generateTickets(money);
        OutputView.printLottoTickets(lottoTickets);
        return lottoTickets;
    }

    private WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        Lotto winningLotto = new Lotto(winningNumbers);
        int bonusNumber = InputView.inputBonusNumber();
        return WinningLotto.from(winningLotto, bonusNumber);
    }

    private List<Rank> match(LottoTickets lottoTickets, WinningLotto winningLotto) {
        return lottoTickets.getLottoTickets().stream()
                .map(lotto -> Rank.from(winningLotto, lotto))
                .collect(Collectors.toList());
    }

    private void summaryLotto(Money money, List<Rank> ranks) {
        LottoResultSummary summary = new LottoResultSummary(ranks, money);
        OutputView.printSummary(summary);
    }
}
