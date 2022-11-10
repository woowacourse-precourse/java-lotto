package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

	public void play() {
		Money money = new Money(InputView.inputMoney());
		LottoTickets lottoTickets = new LottoTickets(buyTickets(money));
		lottoTickets.print();
	}

	private List<Lotto> buyTickets(Money money) {
		int count = money.getAmount() / LottoMachine.LOTTO_COST;

		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			lottos.add(new Lotto(LottoMachine.issueLottoNumber()));
		}
		return lottos;
	}
}
