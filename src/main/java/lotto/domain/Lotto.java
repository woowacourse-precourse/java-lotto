package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int PRICE = 1_000;
    public static final int SIZE = 6;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto issue() {
        ArrayList<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public LottoResult getLottoResult(Set<Integer> winningNumbers, int bonusNumber) {
        int correctCount = 0;
        boolean havingBonusNumber = false;

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                correctCount++;
               continue;
            }

            if (number == bonusNumber) {
                havingBonusNumber = true;
            }
        }

        return new LottoResult(correctCount, havingBonusNumber);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateOverlap(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
