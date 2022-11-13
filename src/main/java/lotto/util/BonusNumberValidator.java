package lotto.util;

import org.junit.platform.commons.util.StringUtils;

public class BonusNumberValidator implements Validator {
    private final String EMPTY_ERROR = "[ERROR] 보너스 번호를 입력해주세요.";

    @Override
    public void validate(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(EMPTY_ERROR);
        }
    }
}
