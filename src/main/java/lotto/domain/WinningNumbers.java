package lotto.domain;

import java.util.List;
import java.util.Set;

import lotto.exception.ErrorMessage;
import lotto.view.OutputView;

public class WinningNumbers {

	private final List<Integer> numbers;

	public WinningNumbers(List<Integer> numbers) {
		validateWinningNumbers(numbers);
		this.numbers = numbers;
	}

	private void validateWinningNumbers(List<Integer> numbers) {
		validateCount(numbers);
		validateRange(numbers);
		validateDuplicate(numbers);
	}

	private void validateCount(List<Integer> numbers){
		if (numbers.size() != LottoRule.NUMBER_COUNT.getValue()){
			OutputView.printError(ErrorMessage.NUMBER_COUNT_ERROR);
			throw new IllegalArgumentException();
		}
	}

	private void validateRange(List<Integer> numbers){
		for(Integer number : numbers){
			checkRange(number);
		}
	}

	private void validateDuplicate(List<Integer> numbers){
		if(Set.copyOf(numbers).size()!= LottoRule.NUMBER_COUNT.getValue()){
			OutputView.printError(ErrorMessage.DUPLICATE_NUMBER_ERROR);
			throw new IllegalArgumentException();
		}
	}

	private void checkRange(Integer number){
		if (number<LottoRule.MIN_NUMBER.getValue() || number>LottoRule.MAX_NUMBER.getValue()){
			OutputView.printError(ErrorMessage.NUMBER_RANGE_ERROR);
			throw new IllegalArgumentException();
		}
	}
}
