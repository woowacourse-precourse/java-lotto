package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		
		Set<Integer> numberSet = new HashSet<>();
		for(int number : numbers) {
			numberSet.add(number);
		}
		
		if (numberSet.size() != 6) {
			throw new IllegalArgumentException();
		}
	}
	
	public List<Integer> getLotto() {
		return numbers;
	}
}
