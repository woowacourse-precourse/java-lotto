package lotto;

public class BonusNumber {
	private int bonusNumber;

	public BonusNumber(String userInput) {
		bonusNumber = Integer.parseInt(userInput);
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
