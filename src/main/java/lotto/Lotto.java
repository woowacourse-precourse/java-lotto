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
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}

		Set<Integer> duplicateCheck = new HashSet<>();
		
		for (int number : numbers) {
			if(number < 1 || 45 < number) {
				throw new IllegalArgumentException();
			}
			
			duplicateCheck.add(number);
		}
		
		if (duplicateCheck.size() != 6) {
			throw new IllegalArgumentException();
		}
	}
	
	public List<Integer> getLotto() {
		return numbers;
	}
}
