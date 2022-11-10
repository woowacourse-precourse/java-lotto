package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoTicket;

public class LottoController {

	public void run() {
		LottoTicket lottoTicket = new LottoTicket(LottoNumberGenerator.generate());
	}

}
