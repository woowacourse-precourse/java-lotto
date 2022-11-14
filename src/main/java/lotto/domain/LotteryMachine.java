package lotto.domain;

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
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidNumberOfLottoNumbers());
		}
		if (isInvalidLottoNumber(numbers)) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidLottoNumber());
		}
	}

	private boolean isInvalidLottoNumber(List<Integer> numbers) {
		return numbers.stream()
			.anyMatch(number -> number < 0 || number > 45);
	}

}
