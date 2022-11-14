package lotto.controller.dto;

import java.util.List;

public class WinningNumberDto {

	private List<Integer> winningNumbers;
	private Integer bonusNumber;

	public WinningNumberDto(List<Integer> winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}

	public Integer getBonusNumber() {
		return bonusNumber;
	}

	public void setBonusNumber(Integer bonusNumber) {
		this.bonusNumber = bonusNumber;
	}

}
