package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class BonusNumber {
    private static final int BONUS_NUMBER_SIZE = 1;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private final List<Integer> bonus;

    public BonusNumber(List<Integer> bonus, Lotto winning) {
        validateSize(bonus);
        validateRange(bonus);
        validateDuplicateWinning(bonus, winning);
        this.bonus = List.copyOf(bonus);
    }

    private static void validateSize(List<Integer> bonus) {
        if (bonus.size() != BONUS_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] Must enter 1 bonus numbers.");
        }
    }

    private static void validateRange(List<Integer> bonus) {
        if (bonus.stream()
                .anyMatch(BonusNumber::inRange)) {
            throw new IllegalArgumentException("[ERROR] Must enter a number from 1 to 45.");
        }
    }

    private static boolean inRange(int number) {
        return number < START_NUMBER || number > END_NUMBER;
    }

    private static void validateDuplicateWinning(List<Integer> bonus, Lotto winning) {
        if (winning.get()
                .stream()
                .anyMatch(number -> Objects.equals(bonus.get(0), number))) {
            throw new IllegalArgumentException("[ERROR] Must enter a number that does not overlap with the winning number.");
        }
    }

    public List<Integer> get() {
        return bonus;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        BonusNumber bonusNumber = (BonusNumber) object;
        return Objects.equals(bonus, bonusNumber.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonus);
    }

    @Override
    public String toString() {
        return bonus.toString();
    }
}
