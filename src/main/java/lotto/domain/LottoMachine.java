package lotto.domain;

import java.util.List;

public class LottoMachine {

	private List<Integer> winningNumbers;
	private int bonusNumber;

	public LottoMachine(List<Integer> winningNumbers, int bonusNumber) {
		checkException(winningNumbers, bonusNumber);

		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}

	private void checkException(List<Integer> lotto, int bonus) {
		if (lotto.contains(bonus)) {
			throw new IllegalArgumentException("[ERROR] 로또 번호와 다른 보너스 숫자를 입력해주세요.");
		}
	}
}
