package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        hasDuplicate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Errors.NOT_SIX_NUMBERS.toString());
        }
    }

    private void hasDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(Errors.NOT_DUPLICATE_NUMBER.toString());
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> target = new ArrayList<>();
        target.addAll(numbers);
        Collections.sort(target);
        return target;
    }

    public void isDuplicateBonusNumber(int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(Errors.WRONG_BONUS.toString());
        }
    }

    private int compareNumber(Lotto target) {
        target.numbers.retainAll(this.numbers);
        return target.numbers.size();
    }

    public int getRanking(Lotto target, int bonus) {
        int sameNumber = compareNumber(target);
        if (sameNumber == 6) {
            return 1;
        } else if (sameNumber == 5) {
            if (target.numbers.contains(bonus)) {
                return 2;
            }
            return 3;
        } else if (sameNumber == 4) {
            return 4;
        } else if (sameNumber == 3) {
            return 5;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
