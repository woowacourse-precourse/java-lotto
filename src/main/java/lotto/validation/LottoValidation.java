package lotto.validation;

import lotto.utils.ConsoleLog;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static lotto.utils.Constant.ERROR_PREFIX;

public enum LottoValidation {
    NOT_SIX_NUMBERS(
            "생성 된 로또가 6개의 숫자가 아닙니다.",
            numbers -> numbers.size() != 6
    ),
    DUPLICATED(
            "생성 된 로또에 중복된 숫자가 존재합니다.",
            numbers -> new HashSet<>(numbers).size() != 6
    );

    private final String errorMessage;
    private final Function<List<Integer>, Boolean> expression;

    LottoValidation(String errorMessage, Function<List<Integer>, Boolean> expression) {
        this.errorMessage = errorMessage;
        this.expression = expression;
    }

    private String errorMessage() {
        return ERROR_PREFIX + errorMessage;
    }

    private static Optional<LottoValidation> validate(List<Integer> numbers) {
        return Stream.of(values())
                .filter(enumType -> enumType.expression.apply(numbers))
                .findFirst();
    }

    public static void checkValidation(List<Integer> numbers) {
        validate(numbers).ifPresent(enumType -> {
            ConsoleLog.getInstance().println(enumType.errorMessage());
            throw new IllegalArgumentException(enumType.errorMessage());
        });
    }
}
