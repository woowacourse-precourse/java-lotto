package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
	public static final int SIZE_OF_LOTTO = 6;
	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != SIZE_OF_LOTTO) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 "+ SIZE_OF_LOTTO +"개 입니다.");
		}

		if (new HashSet<>(numbers).size() != numbers.size()) {
			throw new IllegalArgumentException("[ERROR] 중복된 로또 번호입니다.");
		}

		if (numbers.stream().anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 "+ MIN_LOTTO_NUMBER +"부터 " + MAX_LOTTO_NUMBER + "사이의 숫자여야 합니다.");
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
