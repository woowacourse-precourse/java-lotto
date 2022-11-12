package lotto.domain;

import static lotto.domain.LottoBonusValidator.*;

public class LottoBonus {
	private int bonusNumber;

	public LottoBonus(int bonusNumber) {
		validate(bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	public int getBonusNumber() {
		return this.bonusNumber;
	}
}
