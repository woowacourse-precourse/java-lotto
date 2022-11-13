package lotto;

public class Bonus {
	private final int BONUS;
	private String errorMessage = "[ERROR] ";
	
	public Bonus(int bonus) {
		validate(bonus);
		BONUS = bonus;
	}
	
	private void validate(int bonus) {
		if (bonus < 1 || 45 < bonus) {
			errorMessage += "1 이상 45 이하의 숫자를 선택해 주세요.";
			throwException();
		}
	}
	
	private void throwException() {
		try {
			throw new IllegalArgumentException();
		} catch(IllegalArgumentException e) {
			System.out.println(errorMessage);
			return;
		}
	}
	
	public int getBonus() {
		return BONUS;
	}
}
