package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        uniqueWinningNum(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.ERROR_MESSAGE);
        }
    }

    public void uniqueWinningNum(List<Integer> numbers){
        Set<Integer> uniqueWinNumbers = new HashSet<>(numbers);
        if (uniqueWinNumbers.size() != 6){
            throw new IllegalArgumentException(Message.ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }


}
