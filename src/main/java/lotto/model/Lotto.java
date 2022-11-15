package lotto.model;

import static lotto.model.LotteryInformation.*;

import java.util.List;

import lotto.validator.LottoValidator;

public class Lotto {
	private static LottoValidator lottoValidator;
	private final List<Integer> numbers;

	public Lotto(String numbers) {
		lottoValidator = new LottoValidator();
		this.numbers = lottoValidator.validateWinningNumbers(numbers);
	}

	public void drawBonusNumber(String inputBonusNumber) {
		Integer bonusNumber = lottoValidator.validateBonusNumber(inputBonusNumber);
		numbers.add(BONUS_NUMBER_DIGIT.getCode(), bonusNumber);
	}

	public List<Integer> getWinningNumbers() {
		return numbers;
	}
}
