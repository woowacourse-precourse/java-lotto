package lotto;

import java.util.List;

public class NumbersValidator {

    public static void validateWinningNumber(List<Integer> numbers, int bonusNumber){
        validateLotto(numbers);

        if (numbers.contains(bonusNumber)){
            throw new IllegalArgumentException();
        }

    }

    public static void validateLotto(List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE
                || isOverlapping(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOverlapping(List<Integer> numbers){
        return numbers.stream().distinct().count() != numbers.size();
    }
}
