package lotto.view.validation;

import lotto.exception.ExceptionPhrase;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class MoneyValidation implements Validation{

    private final String regex = "[0-9]";

    private static final Logger logger = Logger.getGlobal();

    @Override
    public void validateInputIsInteger(String input) {

        input = input.replaceAll(regex,"");

        if(input.length() != 0) {
            System.out.println(ExceptionPhrase.EXCEPTION_INVALID_INPUT.getMessage());
            throw new NoSuchElementException();
        }
    }
}
