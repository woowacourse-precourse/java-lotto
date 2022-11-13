package lotto.controller;

import lotto.controller.validator.Validator;

public interface Controller {

    default void validateInput(String input, Validator... validators) {
        for (Validator validator : validators) {
            if (!validator.getPredicate().test(input)) {
                throw new IllegalArgumentException(validator.getErrorMessage());
            }
        }
    }

}
