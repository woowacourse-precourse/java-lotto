package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    private final List<Integer> numbers;
    private int bonusNumber;

    public Player(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        checkSize(numbers);
        checkDuplicate(numbers);
        numbers.forEach(this::checkRange);
        checkRange(bonusNumber);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> check = new HashSet<>(numbers);

        if (check.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    public void compare(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchingNumber = lotto.getMatchingNumber(numbers);
        }

    }

}
