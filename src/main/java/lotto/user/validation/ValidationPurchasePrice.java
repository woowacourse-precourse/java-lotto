package lotto.user.validation;

import java.util.function.Function;
import java.util.regex.Pattern;

public enum ValidationPurchasePrice {
    CHECK_PRICE_INTEGER(price -> Pattern.matches("^[0-9]*$", price), "[ERROR] 금액은 자연수여야 합니다.", true),
    CHECK_PRICE_NUMBER(money -> Integer.parseInt(money) % 1000 == 0,
            "[ERROR] 로또 번호는 중복값이 없어야 합니다.", true),
    CHECK_PRICE_POSITIVE(money -> Integer.parseInt(money) >= 0,
            "[ERROR] 금액은 양수여야 합니다.", true),
    NORMAL((numbers) -> (true), "", false);

    private Function<String, Boolean> expression;
    private String errorMessage;
    private Boolean isThrow;

    public String getErrorMessage() {
        return errorMessage;
    }

    public Boolean getIsThrow() {
        return isThrow;
    }

    ValidationPurchasePrice(Function<String, Boolean> expression, String errorMessage, Boolean isThrow) {
        this.expression = expression;
        this.errorMessage = errorMessage;
        this.isThrow = isThrow;
    }
}
