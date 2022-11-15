package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호 6개를 입력해주세요.");
        }

        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("로또의 각 번호는 중복이 없어야 합니다.");
        }
    }

    private int getCorrectCount(List<Integer> answer) {
        int count = 0;
        for (Integer number : getNumbers()) {
            if (answer.contains(number)) count += 1;
        }

        return count;
    }

    private int getPlace(int correct, int bonus) {
        if (correct == 6) return 1;
        if (correct == 5 && getNumbers().contains(bonus)) return 2;
        if (correct == 5) return 3;
        if (correct == 4) return 4;
        if (correct == 3) return 5;
        return 0;
    }

    public int draw(List<Integer> answer, int bonus) {
        int correct = getCorrectCount(answer);
        return getPlace(correct, bonus);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}