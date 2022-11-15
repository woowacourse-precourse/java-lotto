package lotto.controller.dto;

import lotto.controller.validator.Validator;

public interface Dto {

    default void validateInput(String input, Validator... validators) {
        for (Validator validator : validators) {
            if (!validator.getPredicate().test(input)) {
                throw new IllegalArgumentException(validator.getErrorMessage());
            }
        }
    }
}
