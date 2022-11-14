package lotto.domain;

import static lotto.domain.Lotto.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.ErrorMessage;

public class LotteryMachine {

	private final Set<Integer> numbers;
	private Integer bonusNumber;

	private LotteryMachine(List<Integer> numbers) {
		validate(numbers);
		this.numbers = new HashSet<>(numbers);
	}

	public static LotteryMachine of(List<Integer> numbers) {
		return new LotteryMachine(numbers);
	}

	public Set<Integer> getNumbers() {
		return numbers;
	}

	public Integer getBonusNumber() {
		return bonusNumber;
	}

	public void setBonusNumber(Integer bonusNumber) {
		validate(bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	private void validate(Integer number) {
		if (isInvalidLottoNumber(List.of(number))) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidLottoNumber());
		}
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != NUMBER_OF_LOTTO) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidNumberOfLottoNumbers());
		}
		if (isInvalidLottoNumber(numbers)) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidLottoNumber());
		}
	}

	private boolean isInvalidLottoNumber(List<Integer> numbers) {
		return numbers.stream()
			.anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER);
	}

}
