package ExceptionCollections;

import java.util.List;

public class WinningNumbersExeption extends CommonException {
    public static void validate(List<String> numbers) {
        validateNumberLength(numbers);
        for (String number : numbers) {
            hasCharacters(number);
            validateNumberRange(stringToInteger(number));
            hasDuplicatedNumber(numbers, number);
        }
    }
}