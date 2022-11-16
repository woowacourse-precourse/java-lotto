package lotto.view.validation;

import lotto.exception.ExceptionPhrase;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

import static lotto.exception.ExceptionPhrase.EXCEPTION_INVALID_INPUT;

public class MoneyValidation implements Validation{

    private final String regex = "[0-9]";

    private static final Logger logger = Logger.getGlobal();

    @Override
    public void validateInputIsInteger(String input) throws IllegalArgumentException{

        input = input.replaceAll(regex,"");

        if(!input.matches("[1-9]+[0-9]*")) {
//            System.out.println(EXCEPTION_INVALID_INPUT.getMessage());
            throw new IllegalArgumentException(EXCEPTION_INVALID_INPUT.getMessage());
        }
    }
}
