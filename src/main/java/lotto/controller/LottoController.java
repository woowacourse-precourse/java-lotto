package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;

public class LottoController {

	public void run() {
		Lotto lotto = new Lotto(LottoNumberGenerator.generate());
	}

}
