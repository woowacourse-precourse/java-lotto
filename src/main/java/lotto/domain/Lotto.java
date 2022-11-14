package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[Error] 발행된 로또 번호는 6개로 이루어져야 합니다.");
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException("[ERROR] 발행된 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public void addLotto() {
        User.setLotteries(numbers);
    }
}
