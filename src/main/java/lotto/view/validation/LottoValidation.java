package lotto.view.validation;

import lotto.exception.ExceptionPhrase;

import java.util.NoSuchElementException;

public class LottoValidation implements Validation{
    @Override
    public void validateInputIsInteger(String input) {
        String[] numbers = input.split(",");
        for (String number : numbers) {
            number = number.trim();
            number = number.replaceAll("[0-9]","");
            if(number.length() != 0) {
                System.out.println(ExceptionPhrase.EXCEPTION_INVALID_INPUT);
                throw new NoSuchElementException();
            }
        }
    }

    public void validateBonusNumber(String number) {
        number = number.replaceAll("[]0-9]","");
        if(number.length() != 0) {
            System.out.println(ExceptionPhrase.EXCEPTION_INVALID_INPUT);
            throw new NoSuchElementException();
        }
    }

}
