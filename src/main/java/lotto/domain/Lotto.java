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
            System.out.println("[ERROR] 로또 번호는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.stream()
                .filter(n -> n < 1 || n > 45)
                .count() > 0) {
            System.out.println("[ERROR] 로또 번호는 1과 45사이여야 합니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.size() > numbers.stream().distinct().count()) {
            System.out.println("[ERROR] 로또 번호 사이에 같은 번호가 없어야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
