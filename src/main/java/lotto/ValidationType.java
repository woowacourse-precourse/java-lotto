package lotto;

import java.util.List;
import java.util.function.Function;

public enum ValidationType {
    CHECK_SIZE_NUMBERS(numbers -> numbers.size() == 6,
            "[ERROR] 로또 번호는 6개 입력하셔야 합니다."),
    CHECK_DUPLICATE_NUMBERS(numbers -> numbers.stream().distinct().count() == 6,
            "[ERROR] 로또 번호는 중복값이 없어야 합니다."),
    CHECK_RANGE_NUMBERS(numbers -> numbers.stream()
            .filter(number -> number >= 1)
            .filter(number -> number <= 45)
            .count() == 6,
            "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private Function<List<Integer>, Boolean> expression;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    ValidationType(Function<List<Integer>, Boolean> expression, String errorMessage) {
        this.expression = expression;
        this.errorMessage = errorMessage;
    }

    public Boolean validateNumbers(List<Integer> numbers) {
        return expression.apply(numbers);
    }
}
