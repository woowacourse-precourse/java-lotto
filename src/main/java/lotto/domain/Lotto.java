package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    protected void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.stream().filter(n -> 1 <= n && n <= 45).count() != 6) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 자연수여야 합니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != 6) {
            System.out.println("[ERROR] 로또 번호는 중복이 없어야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
