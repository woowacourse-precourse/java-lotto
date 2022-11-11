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

    public int draw(List<Integer> answer, int bonus) {
        int correct = getCorrectCount(answer);
        if (correct == 6) return 1;
        if (correct == 5 && getNumbers().contains(bonus)) return 2;
        if (correct == 5) return 3;
        if (correct == 4) return 4;
        if (correct == 3) return 5;
        return 0;
    }

    private int getCorrectCount(List<Integer> answer) {
        int count = 0;
        for (Integer number : getNumbers()) {
            if (answer.contains(number)) count += 1;
        }
        return count;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

}
