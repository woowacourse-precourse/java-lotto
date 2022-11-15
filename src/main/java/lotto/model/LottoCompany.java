package lotto.model;

import java.util.List;

public class LottoCompany {

	private final String ERROR_BONUS_NUMBER = "[ERROR] 보너스 번호가 당첨번호와 중복됩니다.";
	private final List<Integer> winningNumber;
	private final int bonusNumber;

	public LottoCompany(List<Integer> winningNumber, int bonusNumber) {
		Lotto validateNumber = new Lotto(winningNumber);
		this.winningNumber = validateNumber.getNumbers();
		this.bonusNumber = bonusNumber;
		validateBonusNumber();
	}

	private void validateBonusNumber() {
		if (hasBonusNumber(this.winningNumber, this.bonusNumber)) {
			throw new IllegalArgumentException(ERROR_BONUS_NUMBER);
		}
	}

	private boolean hasBonusNumber(List<Integer> winningNumber, int bonusNumber) {
		return winningNumber.stream().anyMatch(number -> number.equals(bonusNumber));
	}
	public List<Integer> getWinningNumber() {
		return winningNumber;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
