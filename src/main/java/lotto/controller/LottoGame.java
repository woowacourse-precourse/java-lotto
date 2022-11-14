package lotto.controller;

import lotto.model.GenerateLotto;
import lotto.model.Money;
import lotto.view.OutputView;
public class LottoGame {
    public void play() {
        Money money = new Money();
        money.setInputMoney();
        GenerateLotto generateLotto = new GenerateLotto();
        OutputView.lottoTicketsOut();
    }
}