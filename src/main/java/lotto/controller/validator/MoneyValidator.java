package lotto.controller.validator;

import lotto.domain.Config;

import java.util.function.Predicate;

public enum MoneyValidator implements Validator {

    IS_NATURAL_NUMBER(
            "[ERROR] 구입금액은 0 이상인 숫자여야 합니다.",
            (String input) -> input.chars()
                    .map(i -> (char) i)
                    .allMatch(c -> Character.getType(c) == Constants.NUMBER_TYPE)
    ),
    ;

    private final String errorMessage;
    private final Predicate<String> predicate;

    MoneyValidator(String errorMessage, Predicate<String> predicate) {
        this.errorMessage = errorMessage;
        this.predicate = predicate;
    }

    public Predicate<String> getPredicate() {
        return predicate;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static class Constants {
        public static final  int NUMBER_TYPE = 9;
    }
}
