package lotto.util;

import org.junit.platform.commons.util.StringUtils;

public class WinningNumberValidator implements Validator {
    private final String EMPTY_ERROR = "[ERROR] 금액을 입력해주세요.";

    @Override
    public void validate(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(EMPTY_ERROR);
        }
    }
}
