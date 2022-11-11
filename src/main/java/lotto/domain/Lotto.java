package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>();
        this.numbers.sort(Comparator.naturalOrder());
    }

    private void validate(List<Integer> numbers) {
        isCorrectSize(numbers);
        isDuplication(numbers);
        isCorrectNumber(numbers);
    }

    private void isCorrectNumber(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        });
    }

    private void isDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    private void isCorrectSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("숫자 6개를 입력해주세요.");
        }
    }
}
