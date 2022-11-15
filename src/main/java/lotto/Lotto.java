package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (checkSize(numbers) || checkRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }
    
    private boolean checkSize(List<Integer> numbers) {
    	return numbers.size() != Game.LOTTO_SIZE;
    }
    
    private boolean checkRange(List<Integer> numbers) {
    	for (Integer number : numbers) {
    		if (number > Game.START_RANGE || number < Game.END_RANGE) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public List<Integer> getLottoNumbers(){
    	return this.numbers;
    }
    
}