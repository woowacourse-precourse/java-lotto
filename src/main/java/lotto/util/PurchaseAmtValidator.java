package lotto.util;

import org.junit.platform.commons.util.StringUtils;

public class PurchaseAmtValidator implements Validator {
    private final String EMPTY_ERROR = "[ERROR] 금액을 입력해주세요.";
    private final String NUMERIC_ERROR = "[ERROR] 숫자만 입력해주세요.";
    private final String LOW_AMT_ERROR = "[ERROR] 천 원 이상 입력해주세요.";
    private final String PURCHASE_AMT_ERROR = "[ERROR] 1000원 단위를 입력해주세요.";
    private final int MIN_UNIT = 1000;


    @Override
    public void validate(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(EMPTY_ERROR);
        }
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
        int inputAmt = Integer.parseInt(input);
        if (inputAmt < MIN_UNIT) {
            throw new IllegalArgumentException(LOW_AMT_ERROR);
        }
        if (inputAmt % MIN_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_AMT_ERROR);
        }
    }
}
