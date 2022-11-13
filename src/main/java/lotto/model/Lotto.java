package lotto.model;

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

    public Integer countIssueingLotto(int PurchaseAmount) {
        // TODO: 로또 구입 금액 검증
        return PurchaseAmount / 1000;
    }
}
