package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    int prize;
    int prizeMoney;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numbersToCheck = new HashSet<>(numbers);
        if (numbers.size() != numbersToCheck.size()) {
            System.out.println("[ERROR] 로또 번호는 중복된 값을 가질 수 없습니다.");
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 값을 가질 수 없습니다.");
        }
    }

    void addPrize(int prize) {
        this.prize = prize;
    }

    void addPrizeMoney(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    List<Integer> getNumbers() {
        return numbers;
    }

    int getPrize() {
        return prize;
    }

    int getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
