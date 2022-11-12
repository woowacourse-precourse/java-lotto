package lotto.domain;

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

    public int draw(List<Integer> answer, int bonus) {
        int rank;
        int count = countSameNumber(answer);

        rank = getRank(count);
        if (count == 5 && numbers.contains(bonus)) {
            rank = 2;
        }

        return rank;
    }

    private int countSameNumber(List<Integer> answer) {
        int count = 0;

        for (Integer number : numbers) {
            if (answer.contains(number)) {
                count++;
            }
        }

        return count;
    }

    private int getRank(int count) {
        if (count == 3) {
            return 5;
        }
        if (count == 4) {
            return 4;
        }
        if (count == 5) {
            return 3;
        }
        if (count == 6) {
            return 1;
        }
        return 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
