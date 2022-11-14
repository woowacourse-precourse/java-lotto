package lotto.util;

import org.junit.platform.commons.util.StringUtils;

public class BonusNumberValidator implements Validator {
    private final String BONUS_NUM_PATTERN = "^[1-9]$|^[1-3][0-9]$|^4[0-5]$";
    private final String EMPTY_ERROR = "[ERROR] 보너스 번호를 입력해주세요.";
    private final String NUMERIC_ERROR = "[ERROR] 숫자만 입력해주세요.";
    private final String NON_MATCHING_ERROR = "[ERROR] 패턴 형식에 맞게 입력해주세요.";

    @Override
    public void validate(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(EMPTY_ERROR);
        }
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
        if (!input.matches(BONUS_NUM_PATTERN)) {
            throw new IllegalArgumentException(NON_MATCHING_ERROR);
        }
    }
}
