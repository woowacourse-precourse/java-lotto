package lotto;

public class Bonus {
	private int bonus;

	public Bonus(int bonus) {
		validate(bonus);
		this.bonus = bonus;
	}

	private void validate(int bonus) {
		if (bonus < 1 || 45 < bonus) {
			throwException(ErrorMessage.RANGE_ERROR);
		}
	}

	private void throwException(ErrorMessage errorType) {
		errorType.printErrorMessage();
		throw new IllegalArgumentException();
	}

	public int getBonus() {
		return bonus;
	}
}
