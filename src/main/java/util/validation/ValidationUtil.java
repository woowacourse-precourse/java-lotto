package util.validation;

import static java.util.stream.Collectors.toList;

import java.util.List;
import lotto.Lotto;

public class ValidationUtil {
    public static boolean checkSize(List<Integer> numbers) {
        return numbers.size() != Lotto.SIZE;
    }

    public static boolean haveDuplicatedNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static boolean isUnitsOf1000Won(String purchasePrice) {
        return Integer.parseInt(purchasePrice) % Lotto.PRICE == 0;
    }

    public static boolean haveUndefinedNumber(List<String> numbers) {
        int sizeOfFiltered = numbers.stream()
                .filter(i -> !(i.equals("")))
                .collect(toList())
                .size();

        return sizeOfFiltered != numbers.size();
    }

    public static boolean areInteger(List<String> numbers) {
        int sizeOfFiltered = numbers.stream()
                .filter(ValidationUtil::isInteger)
                .collect(toList())
                .size();

        return sizeOfFiltered == numbers.size();
    }

    public static boolean areValidNumbers(List<String> numbers) {
        return haveSixNumbers(numbers)
                && (!areDuplicated(numbers))
                && (areWithinValidRange(numbers));
    }

    public static boolean haveSixNumbers(List<String> numbers) {
        return numbers.size() == Lotto.SIZE;
    }

    public static boolean areDuplicated(List<String> numbers) {
        long sizeOfFiltered = numbers.stream()
                .distinct()
                .collect(toList())
                .size();

        return sizeOfFiltered != numbers.size();
    }

    public static boolean areWithinValidRange(List<String> numbers) {
        int sizeOfFiltered = (int) numbers.stream()
                .filter(ValidationUtil::isWithinValidRange)
                .count();

        return sizeOfFiltered == numbers.size();
    }

    public static boolean checkSize(String bonusNumber) {
        return bonusNumber.length() != Lotto.BONUS_SIZE;
    }

    public static boolean isWithinValidRange(String input) {
        int number = Integer.parseInt(input);

        return (number >= Lotto.FIRST_NUMBER) && (number <= Lotto.LAST_NUMBER);
    }
}
