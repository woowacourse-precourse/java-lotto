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
    
    public List<Integer> getNumbers() {
		return numbers;
	}

	private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 총 6개여야 합니다.");
        }
        if(!isCorrectRange(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if(!isUniqueNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호들 중 같은 번호가 있으면 안됩니다.");
        }
    }

    private boolean isCorrectRange(List<Integer> numbers) {
    	for(Integer number : numbers) {
    		if(number < 1 || number > 45) {
    			return false;
    		}
    	}
    	return true;
    }
    
    private boolean isUniqueNumber(List<Integer> numbers) {
    	Set<Integer> existedNumbers = new HashSet<>();
    	
    	for(Integer number : numbers) {
    		if(existedNumbers.contains(number)) {
    			return false;
    		}
    		existedNumbers.add(number);
    	}
    	return true;
    }
}
