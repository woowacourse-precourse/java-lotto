package lotto.controller;

import lotto.model.*;
import lotto.view.OutputView;
import lotto.view.InputView;
public class LottoGame {
    public void play() {
        Money money = new Money(InputView.purchaseInput());

        GenerateLotto generateLotto = new GenerateLotto(money.getLottoTickets());
        OutputView.lottoTicketsOut(money.getLottoTickets(), generateLotto.getLotto());

        WinningNumbers winningNumbers = new WinningNumbers(
                InputView.getWinningNumbers(), InputView.getBonusNumber());

        Ranking ranking = new Ranking(generateLotto.getLotto(), winningNumbers);

        Prize prize = new Prize(ranking.getRanking());
    }
}