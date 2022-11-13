package lotto.util;

import org.junit.platform.commons.util.StringUtils;

public class PurchaseAmtValidator implements Validator{
    private final String EMPTY_ERROR = "[ERROR] 금액을 입력해주세요.";
    private final String NUMERIC_ERROR = "[ERROR] 숫자만 입력해주세요.";

    @Override
    public void validate(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(EMPTY_ERROR);
        }
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
    }
}
