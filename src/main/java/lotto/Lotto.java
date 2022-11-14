package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		//여기서 유효성 검사가 필요함.
		//숫자가 6개인지. 각 숫자가 1~45인지. 중복되지 않는지.
		validate(numbers);
		checkDuplicate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자만 입력 가능합니다.");
		}
	}

	private void checkDuplicate(List<Integer> numbers) {
		for (Integer number : numbers) {
			if (Collections.frequency(numbers, number) > 1) {
				throw new IllegalArgumentException("[ERROR] 로또는 중복된 값 입력이 불가능합니다.");
			}
		}
	}

	// TODO: 추가 기능 구현

	public List<Integer> getNumbers() {
		return this.numbers;
	}

}
