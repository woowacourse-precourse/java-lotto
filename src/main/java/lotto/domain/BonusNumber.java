package lotto.domain;

public class BonusNumber {
	private static final String VALID_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1~45의 범위를 가지며, 1개입니다.";
	private static final int MAX_VALUE = 45;
	private static final int MIN_VALUE = 1;
	private final int bonusNumber;

	public BonusNumber(int number) {
		this.bonusNumber = number;
	}

	public void validBonusNumber() {
		if (isWrongRangeBonusNumber(bonusNumber)) {
			throw new IllegalArgumentException(VALID_BONUS_NUMBER_ERROR_MESSAGE);
		}
	}

	private boolean isWrongRangeBonusNumber(int bonusNumber) {
		return !(MIN_VALUE <= bonusNumber && bonusNumber <= MAX_VALUE);
	}
}
