package lotto.dto.lotterystore;

public class WinningNumbersDto {
	private final String winningNumbers;
	private final String bonusNumber;

	public WinningNumbersDto(String winningNumbers, String bonusNumber) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public String getWinningNumbers() {
		return winningNumbers;
	}

	public String getBonusNumber() {
		return bonusNumber;
	}
}
