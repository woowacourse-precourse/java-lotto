package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int correctCount;
    private boolean bonus;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void addCorrectCount() {
        this.correctCount ++;
    }

    public void winBonus() {
        this.bonus = true;
    }
}
