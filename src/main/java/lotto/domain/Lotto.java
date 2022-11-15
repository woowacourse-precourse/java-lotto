package lotto.domain;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int bonusNum;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateScope(numbers);
        validateDuplicate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateScope(List<Integer> numbers) {
        boolean isException = numbers.stream()
                .anyMatch(number -> number < 1 || 45 < number);
        if (isException) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int nonDuplNum = (int) numbers.stream()
                .distinct().count();
        if (nonDuplNum != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
    private int getBonusNumbers() {
        return bonusNum;
    }

    public void addBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int compare(Lotto target) {
        List<Integer> targetNumbers = target.getNumbers();
        int matchNum = (int) targetNumbers.stream()
                .filter(num -> this.numbers.contains(num))
                .count();
        return matchNum;
    }

    public boolean hasBonusNum(Lotto numbers) {
        bonusNum = numbers.getBonusNumbers();
        return this.numbers.contains(bonusNum);
    }
}
