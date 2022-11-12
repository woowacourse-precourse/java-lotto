package lotto.domain;

import static lotto.util.ValidUtil.*;

import java.util.List;

public class WinnerNumber {

	private List<Integer> answerNumbers;
	private Integer bonusNumber;

	public WinnerNumber(String answerNumbers) {
		this.answerNumbers = validAnswer(answerNumbers);
	}

	public void updateBonusNumber(String bonus) {
		this.bonusNumber = validateBonus(bonus);
	}

	public List<Integer> getAnswerNumbers() {
		return answerNumbers;
	}

	public Integer getBonusNumber() {
		return bonusNumber;
	}

}
