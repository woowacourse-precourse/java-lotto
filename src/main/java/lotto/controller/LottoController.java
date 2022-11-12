package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.view.InputView;

public class LottoController {

	public void run() {
		LottoTickets lottoTickets = new LottoTickets(InputView.purchaseLotto());
	}

}
