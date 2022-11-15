package lotto;

import java.util.List;
import java.util.function.Function;

public class ValidationBonusNumber {

    private Function<String, Boolean> expression;
    private String errorMessage;
    private Boolean isThrow;

    public String getErrorMessage() {
        return errorMessage;
    }

    public Boolean getIsThrow() {
        return isThrow;
    }

    ValidationBonusNumber(Function<String, Boolean> expression, String errorMessage, Boolean isThrow) {
        this.expression = expression;
        this.errorMessage = errorMessage;
        this.isThrow = isThrow;
    }
}
