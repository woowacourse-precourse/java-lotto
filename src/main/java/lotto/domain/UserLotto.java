package lotto.domain;

import java.util.List;

public class UserLotto {
    private final List<Integer> numbers;

    public UserLotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}