package lotto.controller.dto;

import java.util.List;

public class WinnerNumberDto {

	private List<Integer> answerNumbers;
	private Integer bonusNumber;

	public WinnerNumberDto(List<Integer> answerNumbers) {
		this.answerNumbers = answerNumbers;
	}

	public List<Integer> getAnswerNumbers() {
		return answerNumbers;
	}

	public Integer getBonusNumber() {
		return bonusNumber;
	}

	public void setBonusNumber(Integer bonusNumber) {
		this.bonusNumber = bonusNumber;
	}

}
