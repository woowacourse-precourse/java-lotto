package lotto.domain;

import lotto.ui.Constants;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void view() {
        System.out.println(numbers.toString());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Boolean hasNumber(Integer number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        // 중복된 숫자가 존재할 경우 예외처리
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }

        for (Integer number : numbers) {
            if (!isCorrectRange(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private Boolean isCorrectRange(Integer number) {
        return 1 <= number && number <= 45;
    }

    // TODO: 추가 기능 구현
}
