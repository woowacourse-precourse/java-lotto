package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Validation {

    public void checkNumeric(String input) throws IllegalArgumentException {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(Error.NOT_NUMERIC.message());
        }
    }

    public void checkNumberInRange(int number) throws IllegalArgumentException {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(Error.NOT_IN_RANGE.message());
        }
    }

    public void checkDividable(int number) throws IllegalArgumentException {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(Error.NOT_DIVIDABLE.message());
        }
    }

    public void checkNull(String input) throws IllegalArgumentException {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Error.IS_NULL.message());
        }
    }

    public void checkDuplicate(List<Integer> list) throws IllegalArgumentException {
        if (list.stream().distinct().collect(Collectors.toList()).size() != list.size()) {
            throw new IllegalArgumentException(Error.DUPLICATE_IN_WINNING.message());
        }
    }

    public void checkBonusDuplicate(List<Integer> winning, int bonus)
        throws IllegalArgumentException {
        winning.add(bonus);
        try {
            checkDuplicate(winning);
        } catch (IllegalArgumentException E) {
            throw new IllegalArgumentException(Error.DUPLICATE_IN_BONUS.message());
        }
    }

}
