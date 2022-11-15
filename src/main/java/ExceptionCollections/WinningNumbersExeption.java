package ExceptionCollections;

import java.util.List;

public class WinningNumbersExeption extends CommonException {
    public static void validateWinningNumber(List<String> numbers) {
        validateNumberLength(numbers);
        for (String number : numbers) {
            isEmpty(number);
            hasCharacters(number);
            validateNumberRange(stringToInteger(number));
            hasDuplicatedNumber(numbers, number);
        }
    }
}