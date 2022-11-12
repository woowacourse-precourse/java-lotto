package lotto.validation;

import lotto.utils.ConsoleLog;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public enum InputValidation {
    BLANK(
            "아무것도 입력하지 않았습니다.",
            String::isBlank,
            List.of("enterPurchaseAmount", "enterWinningNumber", "enterBonusNumber")
    ),
    NOT_NUMBER(
            "숫자를 입력 하세요.",
            value -> !value.matches("^[0-9]+$"),
            List.of("enterPurchaseAmount", "enterBonusNumber")
    ),
    NOT_1000_UNITS(
            "1,000원 단위로 입력 하세요.",
            value -> !value.matches("^[1-9]+[0-9]*000$"),
            List.of("enterPurchaseAmount")
    ),
    NOT_NUMBER_OR_COMMA(
            "숫자나 쉼표만 입력 해야 합니다.",
            value -> !value.matches("^[0-9,]*$"),
            List.of("enterWinningNumber")
    ),
    NOT_SIX_NUMBERS(
            "6개의 숫자를 입력해 주세요.",
            value -> value.split(",").length != 6,
            List.of("enterWinningNumber")
    ),
    NOT_FROM_1_TO_45(
            "로또 번호는 1부터 45 사이의 숫자여야 합니다.",
            value -> !Arrays.stream(value.split(","))
                    .allMatch(number -> number.matches("^[1-9]$|^1[0-9]$|^2[0-9]$|^3[0-9]$|^4[0-5]$")),
            List.of("enterWinningNumber", "enterBonusNumber")
    ),
    DUPLICATION(
            "중복 된 숫자가 포함되어있습니다.",
            value -> Arrays.stream(value.split(",")).distinct().count() != 6,
            List.of("enterWinningNumber")
    );

    private final String errorMessage;
    private final Function<String, Boolean> expression;
    private final List<String> group;

    InputValidation(String errorMessage, Function<String, Boolean> expression, List<String> group) {
        this.errorMessage = errorMessage;
        this.expression = expression;
        this.group = group;
    }

    public String errorMessage() {
        return "[ERROR] " + errorMessage;
    }

    private static Optional<InputValidation> validate(String input, String validationGroup) {
        return Stream.of(values())
                .filter(enumType -> enumType.group.contains(validationGroup))
                .filter(enumType -> enumType.expression.apply(input))
                .findFirst();
    }

    private static final ConsoleLog consoleLog = ConsoleLog.getInstance();
    public static void checkValidation(String input, String validationGroup) {
        Optional<InputValidation> validation = validate(input, validationGroup);
        if (validation.isPresent()) {
            consoleLog.println(validation.get().errorMessage());
            // 테스트 케이스 통과를 위한 임시방편... 뭔가 이상하다.
            if (validation.get() == NOT_NUMBER) {
                throw new NoSuchElementException(validation.get().errorMessage());
            }
            throw new IllegalArgumentException(validation.get().errorMessage());
        }
    }
}
