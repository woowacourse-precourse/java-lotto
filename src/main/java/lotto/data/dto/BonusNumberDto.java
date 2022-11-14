package lotto.data.dto;

import lotto.type.ExceptionType;
import utils.Validator.StringValidator;

public class BonusNumberDto {

    private final int bonusNumber;

    BonusNumberDto(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static BonusNumberDto createWithInput(String input) throws IllegalArgumentException{
        validate(input);
        return new BonusNumberDto(Integer.parseInt(input));
    }

    private static void validate(String input) throws IllegalArgumentException {
        if (hasWrongNumberFormat(input)) {
            throw ExceptionType.NUMBER.getException();
        }
    }

    private static boolean hasWrongNumberFormat(String input) {
        return !StringValidator.isNumeric(input);
    }
}
