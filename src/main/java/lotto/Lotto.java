package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> numbers2 = new ArrayList<>(numbers.size());
        for (int number : numbers) {
            numbers2.add(number);
        }
        Collections.sort(numbers2);
        this.numbers = numbers2;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getNumberOfOverlapping(List<Integer> numbers) {
        int overlapCounter = 0;
        for (int number : numbers) {
            if(this.numbers.contains(number)) {
                overlapCounter++;
            }
        }
        return overlapCounter;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Domain.validateOverlapping(numbers);
        for (int number : numbers) {
            Domain.validateNumberRange(number);
        }
    }

    public int getRank(List<Integer> numbers, int bonus) {
        int overlapCounter = getNumberOfOverlapping(numbers);

        if (overlapCounter == 6) {
            return 1;
        }
        if (overlapCounter == 5) {
            if (this.numbers.contains(bonus)) return 2;
            return 3;
        }
        return 8 - overlapCounter;
    }
}
