package lotto.lotto.validation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum ValidationLottoNumbers {
    CHECK_SIZE_NUMBERS(numbers -> numbers.size() == 6,
            "[ERROR] 로또 번호는 6개 입력하셔야 합니다.", true),
    CHECK_DUPLICATE_NUMBERS(numbers -> numbers.stream().distinct().count() == 6,
            "[ERROR] 로또 번호는 중복값이 없어야 합니다.", true),
    CHECK_RANGE_NUMBERS(numbers -> numbers.stream()
            .filter(number -> number >= 1)
            .filter(number -> number <= 45)
            .count() == 6,
            "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
            , true),
    NORMAL((numbers) -> (true), "", false);

    private Function<List<Integer>, Boolean> expression;
    private String errorMessage;
    private Boolean isThrow;

    ValidationLottoNumbers(Function<List<Integer>, Boolean> expression, String errorMessage, Boolean isThrow) {
        this.expression = expression;
        this.errorMessage = errorMessage;
        this.isThrow = isThrow;
    }

    public static ValidationLottoNumbers validate(List<Integer> numbers) {
        return Arrays.stream(ValidationLottoNumbers.values())
                .filter(v -> !v.expression.apply(numbers))
                .findFirst()
                .orElse(NORMAL);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Boolean getIsThrow() {
        return isThrow;
    }
}
