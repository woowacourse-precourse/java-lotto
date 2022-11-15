package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        validateGuessDuplicate(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> guess) throws IllegalArgumentException {
        if (guess.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 6; i++) {
            validateOne(guess.get(i));
        }
    }

    private void validateGuessDuplicate(List<Integer> guess) throws IllegalArgumentException {
        Set<Integer> guessNoDup = new HashSet<>(guess);
        if (guessNoDup.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // check individual
    public static void validateOne(Integer bonus) throws IllegalArgumentException {
        if (bonus > 46 || bonus < 1) {
            throw new IllegalArgumentException();
        }
    }

    // check duplicate of bonus and guess
    public static void validateBonusDuplicate(Integer bonus) throws IllegalArgumentException {
        if (User.guess.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }
}
