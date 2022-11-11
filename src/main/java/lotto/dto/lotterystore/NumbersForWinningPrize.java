package lotto.dto.lotterystore;

public class NumbersForWinningPrize {
	private final String winningPrizeNumbers;
	private final String bonusNumber;

	public NumbersForWinningPrize(String winningPrizeNumbers, String bonusNumber) {
		this.winningPrizeNumbers = winningPrizeNumbers;
		this.bonusNumber = bonusNumber;
	}

	public String getWinningPrizeNumbers() {
		return winningPrizeNumbers;
	}

	public String getBonusNumber() {
		return bonusNumber;
	}
}
