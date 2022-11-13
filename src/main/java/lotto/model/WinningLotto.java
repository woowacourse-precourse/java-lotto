package lotto.model;

import java.util.regex.Pattern;

public class WinningLotto {
    private static final String INVALID_INPUT_PATTERN = "[ERROR] 입력 형식과 맞지 않습니다.";
    private static final Pattern INPUT_PATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$");

    public WinningLotto(String winningLotto) {
        isValidInputPattern(winningLotto);
    }

    private void isValidInputPattern(String winningLotto) {
        if (!INPUT_PATTERN.matcher(winningLotto).matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_PATTERN);
        }
    }
}
