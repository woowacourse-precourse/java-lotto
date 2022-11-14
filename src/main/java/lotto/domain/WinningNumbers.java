package lotto.domain;

import java.util.List;


import lotto.exception.ErrorMessage;
import lotto.view.OutputView;

public class WinningNumbers {

	private final List<Integer> numbers;
	private final int bonusNumber;

	public WinningNumbers(List<Integer> numbers, int bonusNumber) {
		this.numbers = new Lotto(numbers).getNumbers();

		validateBonusNumber(bonusNumber);
		this.bonusNumber = bonusNumber;
	}


	private void validateBonusNumber(int bonusNumber) {
		checkRange(bonusNumber);
		validateDuplicate(bonusNumber);
	}



	private void validateDuplicate(Integer number){
		if(this.numbers.contains(number)){
			OutputView.printError(ErrorMessage.DUPLICATE_BONUS_NUMBER_ERROR);
			throw new IllegalArgumentException();
		}
	}

	private void checkRange(Integer number){
		if (number<LottoRule.MIN_NUMBER.getValue() || number>LottoRule.MAX_NUMBER.getValue()){
			OutputView.printError(ErrorMessage.NUMBER_RANGE_ERROR);
			throw new IllegalArgumentException();
		}
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
