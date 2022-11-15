package lotto.controller.validator;

import java.util.Arrays;
import java.util.function.Predicate;


public enum WinningNumberValidator implements Validator{

    IS_SEPERATED_BY_COMMA(
            "[ERROR] 입력 형식이 잘못되었습니다.",
            (String input) -> Arrays.stream(input.split(Constants.DELIMITER))
                            .map(String::trim)
                            .allMatch(s -> {
                                try {
                                    Integer.parseInt(s);
                                    return true;
                                } catch (NumberFormatException e) {
                                    return false;
                                }
                            })
            ),
    ;

    private final String errorMessage;
    private final Predicate<String> predicate;

    WinningNumberValidator(String errorMessage, Predicate<String> predicate) {
        this.errorMessage = errorMessage;
        this.predicate = predicate;
    }

    public Predicate<String> getPredicate() {
        return predicate;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    private static class Constants {
        private static final String DELIMITER = ",";
    }

}
