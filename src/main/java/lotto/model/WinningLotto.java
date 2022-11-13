package lotto.model;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final String INVALID_INPUT_PATTERN = "[ERROR] 입력 형식과 맞지 않습니다.";
    private static final Pattern INPUT_PATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$");
    private final Lotto winningLotto;

    public WinningLotto(String winningLotto) {
        isValidInputPattern(winningLotto);
        this.winningLotto = convert(winningLotto);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    private void isValidInputPattern(String winningLotto) {
        if (!INPUT_PATTERN.matcher(winningLotto).matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_PATTERN);
        }
    }

    private Lotto convert(String winningLotto) {
        return new Lotto(Arrays.stream(winningLotto.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }
}
