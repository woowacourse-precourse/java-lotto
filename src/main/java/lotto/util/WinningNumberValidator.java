package lotto.util;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class WinningNumberValidator implements Validator {
    private final static String WINNING_NUM_PATTERN = "(^[1-9]|^[1-3][0-9]|^4[0-5])(,[1-9]|,[1-3][0-9]|,4[0-5]){5}$";
    private final String EMPTY_ERROR = "[ERROR] 금액을 입력해주세요.";
    private final String NON_MATCHING_ERROR = "[ERROR] 패턴 형식에 맞게 입력해주세요.";
    private final String DUPLICATE_ERROR = "[ERROR] 중복 숫자를 제거해주세요.";

    @Override
    public void validate(String input) {
        List<String> wnList = Arrays.asList(input.split(","));

        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(EMPTY_ERROR);
        }
        if (!input.matches(WINNING_NUM_PATTERN)) {
            throw new IllegalArgumentException(NON_MATCHING_ERROR);
        }
        if (wnList.size() != wnList.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }
}
