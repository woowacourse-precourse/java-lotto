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

	public Lottery checkResult(Lotto lotto) {
		final int count = (int)lotto.getNumbers()
				.stream()
				.filter(numbers::contains)
				.count();
		final boolean hasBonusNumber = lotto.getNumbers()
				.contains(bonusNumber);
		return Lottery.of(count, hasBonusNumber);
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

	private void validate(Integer bonusNumber) {
		if (isInvalidLottoNumber(List.of(bonusNumber))) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidLottoNumber());
		}
		if (isDuplicatedNumber(bonusNumber)) {
			throw new IllegalArgumentException(ErrorMessage.isDuplicatedLottoNumber());
		}
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != NUMBER_OF_LOTTO) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidNumberOfLottoNumbers());
		}
		if (isInvalidLottoNumber(numbers)) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidLottoNumber());
		}
		if (isDuplicatedNumber(numbers)) {
			throw new IllegalArgumentException(ErrorMessage.isDuplicatedLottoNumber());
		}
	}

	private boolean isDuplicatedNumber(List<Integer> numbers) {
		return numbers.size() != numbers.stream().distinct().count();
	}

	private boolean isDuplicatedNumber(Integer bonusNumber) {
		return numbers.contains(bonusNumber);
	}

	private boolean isInvalidLottoNumber(List<Integer> numbers) {
		return numbers.stream()
				.anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER);
	}

}
