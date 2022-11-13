package lotto;

import java.util.List;

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
    }

    // TODO: 추가 기능 구현
    public int countMatch(List<Integer> winningNumbers) {
        int count = 0;

        for (Integer number: winningNumbers){
            if (this.numbers.contains(number)){
                count++;
            }
        }
        return count;
    }

}
