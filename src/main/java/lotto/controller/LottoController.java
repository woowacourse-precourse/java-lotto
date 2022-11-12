package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbersGenerator;
import lotto.domain.LottoTickets;
import lotto.view.InputView;

public class LottoController {

	public void run() {
		try {
			LottoTickets lottoTickets = new LottoTickets(InputView.purchaseLotto());
			Lotto lotto = new Lotto(LottoNumbersGenerator.generate(InputView.lottoNumbers()));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
