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
    IS_IN_BOUNDS(
            "[ERROR] 구입금액이 너무 큽니다.",
            (String input) -> input.length() < String.valueOf(Config.MAX_MONEY).length()
    ),
    IS_PARSEABLE(
            "[ERROR] 입력 형식이 잘못되었습니다.",
            (String input) -> {
                try {
                    Integer.parseInt(input);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
    }
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
        public static final int NUMBER_TYPE = 9;
    }
}
