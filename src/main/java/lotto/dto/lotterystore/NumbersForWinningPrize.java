package lotto.dto.lotterystore;

public class NumbersForWinningPrize {
	private final String numbersForWinningPrize;
	private final String bonusNumber;

	public NumbersForWinningPrize(String numbersForWinningPrize, String bonusNumber) {
		this.numbersForWinningPrize = numbersForWinningPrize;
		this.bonusNumber = bonusNumber;
	}

	public String getNumbersForWinningPrize() {
		return numbersForWinningPrize;
	}

	public String getBonusNumber() {
		return bonusNumber;
	}
}
