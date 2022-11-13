package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;
	private String errorMessage = "[ERROR] ";

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		Collections.sort(numbers);
		this.numbers = numbers;
	}
	
	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			errorMessage += "6개의 번호를 입력해 주세요.";
			throwException();
		}

		Set<Integer> duplicateCheck = new HashSet<>();
		
		for (int number : numbers) {
			if(number < 1 || 45 < number) {
				errorMessage += "1 이상 45 이하의 숫자를 선택해 주세요.";
				throwException();
			}
			
			duplicateCheck.add(number);
		}
		
		if (duplicateCheck.size() != 6) {
			errorMessage += "번호가 중복 되지 않도록 선택해 주세요.";
			throwException();
		}
	}
	
	private void throwException() {
		try {
			throw new IllegalArgumentException();
		} catch(IllegalArgumentException e) {
			System.out.println(errorMessage);
			return;
		}
	}
	
	public List<Integer> getLotto() {
		return numbers;
	}
}
