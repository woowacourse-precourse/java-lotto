package lotto;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	public List<Integer> getnumber() {
		return numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR]");
		}

		if (numbers.size() != numbers.stream().distinct().count()) {
			throw new IllegalArgumentException("[ERROR]");
		}
		
		for(int number : numbers) {
			if(number < 1 || number > 45) {
				throw new IllegalArgumentException("[ERROR]");
			}
		}
	}

	// TODO: 추가 기능 구현
}
