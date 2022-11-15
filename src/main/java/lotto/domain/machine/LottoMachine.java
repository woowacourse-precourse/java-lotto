package lotto.domain.machine;

import lotto.domain.lotto.Lotto;

public class LottoMachine {

	private Lotto lotto;
	private String bonusNumber;

	public LottoMachine(String winLottoNumber, String bonusNumber) {
		this.lotto = new Lotto(winLottoNumber, bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	public Lotto getLotto() {
		return lotto;
	}

	public String getBonusNumber() {
		return bonusNumber;
	}
}
