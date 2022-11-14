package lotto.domain;

import java.util.List;

import lotto.utils.Notice;

public class LottoMachine {
	final int LOTTO_MIN = 1;
	final int LOTTO_MAX = 45;
	private final List<Integer> winningNumbers;
	private final int bonusNumber;

	public LottoMachine(List<Integer> lotto, int bonusNumber) {
		this.winningNumbers = lotto;
		this.bonusNumber = bonusNumber;

		checkException();
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}


	/*
	예외 처리
	 */
	private void checkException() {
		checkNumberRange(bonusNumber);

		checkBonusDuplication(winningNumbers, bonusNumber);
	}

	private void checkNumberRange(int number) {
		if (number< LOTTO_MIN || number > LOTTO_MAX) {
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + Notice.ERROR_RANGE.getNoticeMessage());
		}
	}

	private void checkBonusDuplication(List<Integer> lotto, int bonus) {
		if (lotto.contains(bonus)) {
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + Notice.ERROR_DUPLICATION_BONUS.getNoticeMessage());
		}
	}
}
