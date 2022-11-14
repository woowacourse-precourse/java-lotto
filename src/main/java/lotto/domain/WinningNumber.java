package lotto.domain;

public class WinningNumber {
	private final Lotto winningLotto;
	private final BonusNumber bonusNumber;

	public WinningNumber(Lotto winningLotto, BonusNumber bonusNumber) {
		validateDuplicate(winningLotto, bonusNumber);
		this.winningLotto = winningLotto;
		this.bonusNumber = bonusNumber;
	}

	private void validateDuplicate(Lotto winningLotto, BonusNumber bonusNumber) {
		if (winningLotto.isMatch(bonusNumber.getNumber())) {
			throw new IllegalArgumentException();
		}
	}
}
