package lotto;

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
            LottoTickets lottoTickets = buyLottoTickets(money);

            WinningLotto winningLotto = getWinningLotto();

            summaryLotto(money, lottoTickets, winningLotto);
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
        int bonusNumber = InputView.inputBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void summaryLotto(Money money, LottoTickets lottoTickets, WinningLotto winningLotto) {
        List<Rank> ranks = getRanks(lottoTickets, winningLotto);
        LottoSummary summary = new LottoSummary(ranks, money);
        OutputView.printSummary(summary);
    }

    private List<Rank> getRanks(LottoTickets lottoTickets, WinningLotto winningLotto) {
        return lottoTickets.getLottos().stream()
                .map(winningLotto::match)
                .collect(Collectors.toList());
    }
}
