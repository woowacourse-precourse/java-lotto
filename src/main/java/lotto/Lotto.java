package lotto;

import java.util.HashSet;
import java.util.List;


import static lotto.ErrorMessage.*;
import static lotto.Instance.*;
import static lotto.matchType.*;

public class Lotto {
    private final List<Integer> numbers;
    private int winningResult;
    private boolean bonusResult;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.winningResult = 0;
        this.bonusResult = false;
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

    void matchWinning(List<Integer> winning) {
        int result = 0;
        for (int winNum : winning) {
            if (numbers.contains(winNum)) {
                result++;
            }
        }
        winningResult = result;
    }

    void matchBonus(int bonus) {
        bonusResult = numbers.contains(bonus);
    }

    void matchAll(List<Integer> winning, int bonus) {
        matchWinning(winning);
        matchBonus(bonus);
    }

    matchType getType() {
        matchType type = NONE;
        if (winningResult == 3) {
            type = THREE;
        } else if (winningResult == 4) {
            type = FOUR;
        } else if (!bonusResult && (winningResult == 5)) {
            type = FIVE;
        } else if (bonusResult && (winningResult == 5)) {
            type = FIVE_BONUS;
        } else if (winningResult == 6) {
            type = SIX;
        }
        return type;
    }
}
