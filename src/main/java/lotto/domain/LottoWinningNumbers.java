package lotto.domain;

import java.util.List;

public class LottoWinningNumbers {
	public static final int WINNING_NUMBERS_COUNT = 6;

	private final List<Integer> winningNumbers;
	private final int bonusNumber;

	public LottoWinningNumbers(final List<Integer> winningNumbers, final int bonusNumber) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;  
		validateDuplicate(this.winningNumbers, this.bonusNumber);
	}

	private void validateDuplicate(final List<Integer> winningNumbers,
			final int bonusNumber) {
		if (winningNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호에 포함되어 있습니다.");
		}
	}

	
}
