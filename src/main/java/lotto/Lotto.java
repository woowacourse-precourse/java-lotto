package lotto;

import java.util.*;

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

        for (int i = 1; i <= 45; i++)
            if (Collections.frequency(numbers, i) >= 2) throw new IllegalArgumentException();

        for (int i = 0; i < 6; i++)
            if (numbers.get(i) < 1 || numbers.get(i) > 45) throw new IllegalArgumentException();
    }

    private int get_rank(Lotto win_number, int bonus) {
        int count = 0;
        boolean bonus_match = false;
        for (int i = 0; i < 6; i++) {
            if (Objects.equals(this.numbers.get(i), win_number.numbers.get(i))) {
                count += 1;
            }
            if (bonus == this.numbers.get(i)) bonus_match = true;
        }

        if (count == 5) {
            if (bonus_match) return 2;
            return 3;
        }
        if (count == 6) {
            return 1;
        }
        return 8 - count;
    }

    // TODO: 추가 기능 구현
}
