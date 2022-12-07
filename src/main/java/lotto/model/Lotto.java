package lotto.model;

import static lotto.model.LotteryInformation.*;

import java.util.Collections;
import java.util.List;

import lotto.validator.BonusNumberValidator;
import lotto.validator.NumberValidator;
import lotto.view.OutputView;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		Collections.sort(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		NumberValidator numberValidator = new NumberValidator();
		try {
			numberValidator.runNumberValidator(numbers);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
	}

	public void drawBonusNumber(Integer bonusNumber) {
		// Integer bonusNumber = lottoValidator.validateBonusNumber(inputBonusNumber);
		BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
		try {
			bonusNumber = bonusNumberValidator.runBonusNumberValidator(bonusNumber, numbers);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
		numbers.add(BONUS_NUMBER_DIGIT.getCode(), bonusNumber);
	}

	public List<Integer> getNumbers() {
		// Collections.sort(numbers);
		return numbers;
	}

	public int getBonusNumber() {
		return numbers.get(BONUS_NUMBER_DIGIT.getCode());
	}
}
