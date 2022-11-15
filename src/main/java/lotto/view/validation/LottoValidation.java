package lotto.view.validation;

import lotto.exception.ExceptionPhrase;

import java.util.NoSuchElementException;

public class LottoValidation implements Validation{

    private static final String regex = "[0-9]";
    @Override
    public void validateInputIsInteger(String input) {
        String[] numbers = input.split(",");
        for (String number : numbers) {
            number = number.trim();
            number = number.replaceAll(regex,"");
            if(number.length() != 0) {
                System.out.println(ExceptionPhrase.EXCEPTION_INVALID_INPUT.getMessage());
                throw new NoSuchElementException();
            }
        }
    }

    public void validateBonusNumber(String number) {
        number = number.replaceAll(regex,"");
        if(number.length() != 0) {
            System.out.println(ExceptionPhrase.EXCEPTION_INVALID_INPUT.getMessage());
            throw new NoSuchElementException();
        }
    }

}
