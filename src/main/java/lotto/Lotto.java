package lotto;

import java.util.HashSet;
import java.util.List;


import static lotto.ErrorMessage.*;
import static lotto.Instance.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException(TOO_MUCH_NUMBERS);
        } else if (duplicate(numbers)) {
            throw new IllegalArgumentException(REPETITION_LOTTO_NUMBERS);
        }
    }

    private boolean duplicate(List<Integer> numbers) {
        boolean result = false;
        HashSet<Integer> removeDuplication = new HashSet<>(numbers);
        if (removeDuplication.size() != numbers.size()) {
            result = true;
        }
        return result;
    }

    List<Integer> getNumbers() {
        return numbers;
    }

    int matchWinning(List<Integer> winning) {
        int result = 0;
        for (int winNum : winning) {
            if (numbers.contains(winNum)) {
                result++;
            }
        }
        return result;
    }

    boolean matchBonus(int bonus) {
        return numbers.contains(bonus);
    }
}
