package lotto.presentation.view.validate;

public class LottoReaderValidator {

    public static void validateNumber(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }
    
}
