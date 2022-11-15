package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortLotto(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void sortLotto(List<Integer> numbers) {
        Collections.sort(numbers);
    }
    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> calcResult(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> result = new ArrayList<>();
        int hit = 0, bonusHit = 0;
        for(int num : numbers) {
            if(winningNumbers.contains(num)) {
                hit++;
            }
            if(num == bonusNumber) {
                bonusHit++;
            }
        }
        result.add(hit);
        result.add(bonusHit);
        return result;
    }
}
