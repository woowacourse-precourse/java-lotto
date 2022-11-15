package lotto.controller;

import lotto.model.GenerateLotto;
import lotto.model.Money;
import lotto.model.Ranking;
import lotto.model.WinningNumbers;
import lotto.view.OutputView;
import lotto.view.InputView;
public class LottoGame {
    public void play() {
        Money money = new Money(InputView.purchaseInput());

        GenerateLotto generateLotto = new GenerateLotto(money.getLottoTickets());
        OutputView.lottoTicketsOut(money.getLottoTickets(), generateLotto.getLotto());

        WinningNumbers winningNumbers = new WinningNumbers(
                InputView.getWinningNumbers(), InputView.getBonusNumber());

        new Ranking(generateLotto.getLotto(), winningNumbers);
    }
}