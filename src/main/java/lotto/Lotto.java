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

    public int compare(List<Integer> winNumber) {
        int count = 0;

        for (Integer num : numbers) {
            if (winNumber.contains(num)) {
                count++;
            }
        }

        return count;
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }

    // TODO: 추가 기능 구현
}
