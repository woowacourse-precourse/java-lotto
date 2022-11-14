package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호를 6개 입력해야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호는 허용되지 않습니다.");
        }
    }

    public void display() {
        Collections.sort(this.numbers);
        System.out.println(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public List<Integer> getComparingResult(List<Integer> winningNumbers, Integer bonus) {
        return Arrays.asList(compareTo(winningNumbers), compareToAdditional(bonus));
    }

    public Integer compareTo(List<Integer> winningNumbers) {
        return Math.toIntExact(
                this.numbers.stream()
                        .filter(number -> winningNumbers.contains(number) == true)
                        .count()
        );
    }

    public Integer compareToAdditional(Integer bonus) {
        if (this.numbers.contains(bonus)) {
            return 1;
        }
        return 0;
    }
}
