package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
	private static final String VALIDATE_SIZE_EXCEPTION_MESSAGE = "로또 번호는 6개여야 합니다.";
	private static final String VALIDATE_DUPLICATION_EXCEPTION_MESSAGE = "로또 번호는 중복되면 안됩니다.";
	private static final String VALIDATE_BETWEEN_NUMBERS = "로또 번호는 중복되면 안됩니다.";

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateSize(numbers);
		validateDuplication(numbers);
		validateBetweenNumbers(numbers);
		this.numbers = sortNumbers(numbers);
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != ConstValue.LOTTO_NUMBERS) {
			throw new IllegalArgumentException(VALIDATE_SIZE_EXCEPTION_MESSAGE);
		}
	}

	// TODO: 추가 기능 구현
	private void validateDuplication(List<Integer> numbers) {
		if (isDuplicatedNumber(numbers)) {
			throw new IllegalArgumentException(VALIDATE_DUPLICATION_EXCEPTION_MESSAGE);
		}
	}

	private boolean isDuplicatedNumber(List<Integer> numbers) {
		return numbers.size() != numbers.stream()
			.distinct()
			.count();
	}

	private void validateBetweenNumbers(List<Integer> numbers) {
		if (numbers.stream()
			.anyMatch(number -> ConstValue.MIN_LOTTO_NUMBER > number
				|| number > ConstValue.MAX_LOTTO_NUMBER)) {
			throw new IllegalArgumentException(VALIDATE_BETWEEN_NUMBERS);
		}
	}

	public static Lotto generateLottoNumber() {
		return new Lotto(Randoms.pickUniqueNumbersInRange(ConstValue.MIN_LOTTO_NUMBER,
			ConstValue.MAX_LOTTO_NUMBER, ConstValue.LOTTO_NUMBERS));
	}

	private List<Integer> sortNumbers(List<Integer> lottoNumbers) {
		return lottoNumbers.stream()
			.sorted()
			.collect(Collectors.toList());
	}

	public List<Integer> getNumbers() {
		return new ArrayList<>(numbers);
	}
}
