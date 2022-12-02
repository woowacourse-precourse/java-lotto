package lotto.util;

import static lotto.util.Constants.NUMBER_COUNT;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberValidator extends Validator {

    @Override
    public void validate(String input) throws IllegalArgumentException {
        List<String> winningNumbers = splitByComma(input);
        if(winningNumbers.size()!=NUMBER_COUNT){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_SIZE.getMessage());
        }
    }

    private static List<String> splitByComma(String input) {
        return new ArrayList<>(List.of(Validator.removeSpace(input).split(",")));
    }

}
