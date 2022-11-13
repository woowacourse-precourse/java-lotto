package lotto.validator;


import static lotto.validator.ExceptionStatus.*;

public class InputLottoNumberValidator {

    private static final String REGEX = "^([0-9]*,){5}[0-9]*$";

    public static void validate(String lottoNumbers) {
        if (!lottoNumbers.matches(REGEX)) {
            throw new IllegalArgumentException(REGEX_EXCEPTION.getMessage());
        }
    }
}
