package lotto;

public class Bonus {
	private final int BONUS;
	
	public Bonus(int bonus) {
		validate(bonus);
		BONUS = bonus;
	}
	
	private void validate(int bonus) {
		if (bonus < 1 || 45 < bonus) {
			throw new IllegalArgumentException();
		}
	}
}
