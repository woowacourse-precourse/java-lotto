package lotto.user.validation;

import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Pattern;

public enum ValidationPurchasePrice {
    CHECK_PRICE_INTEGER(price -> Pattern.matches("^[0-9]*$", price),
            "[ERROR] 구입금액은 자연수여야 합니다.", true),
    CHECK_PRICE_NUMBER(money -> Long.parseLong(money) % 1000 == 0,
            "[ERROR] 구입 금액은 1000원 단위여야 합니다.", true),
    CHECK_PRICE_POSITIVE(money -> Long.parseLong(money) >= 0,
            "[ERROR] 금액은 양수여야 합니다.", true),
    NORMAL((numbers) -> (true), "", false);

    private Function<String, Boolean> expression;
    private String errorMessage;
    private Boolean isThrow;

    ValidationPurchasePrice(Function<String, Boolean> expression, String errorMessage, Boolean isThrow) {
        this.expression = expression;
        this.errorMessage = errorMessage;
        this.isThrow = isThrow;
    }

    public static ValidationPurchasePrice validate(String price) {
        return Arrays.stream(ValidationPurchasePrice.values())
                .filter(v -> !v.expression.apply(price))
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
