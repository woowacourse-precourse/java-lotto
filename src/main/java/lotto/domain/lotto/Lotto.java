package lotto.domain.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    
    private final List<Integer> numbers;
    
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        
        this.numbers = numbers;
    }
    
    public List<Integer> getNumbers() {
        return numbers;
    }
    
    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }
    
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    
    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException();
        }
    }
}
