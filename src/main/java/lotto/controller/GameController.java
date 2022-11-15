package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoReceipt;
import lotto.domain.LottoRule;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;

public class GameController {

	public void play() {
		Money money = new Money(InputView.inputMoney());

		LottoTickets lottoTickets = new LottoTickets(buyTickets(money));
		lottoTickets.print();

		WinningNumbers winningNumbers = createWinningNumbers();

		LottoReceipt lottoReceipt = new LottoReceipt(lottoTickets, winningNumbers);
		lottoReceipt.printResult();

		lottoReceipt.calculateRevenue();
		lottoReceipt.printYield(money);
	}

	private void calculateYield(Money money, LottoReceipt lottoReceipt) {

	}

	private List<Lotto> buyTickets(Money money) {
		int count = money.getAmount() / LottoRule.LOTTO_COST.getValue();

		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			lottos.add(new Lotto(LottoMachine.issueLottoNumber()));
		}
		return lottos;
	}

	private WinningNumbers createWinningNumbers() {
		return new WinningNumbers(InputView.inputWinningNumbers(), InputView.inputBonusNumbers());
	}
}
