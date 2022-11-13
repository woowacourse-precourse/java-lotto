package lotto.model;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final String INVALID_INPUT_PATTERN = "[ERROR] 입력 형식과 맞지 않습니다.";
    private static final Pattern INPUT_PATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$");
    private static final String BONUS_NUMBER_IS_DUPLICATED_WITH_WINNING_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
    private static final String INVALID_NUMBER_RANGE = "[ERROR] 로또 번호의 범위는 1 ~ 45까지 입니다.";
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(String winningLotto, int bonusNumber) {
        isValidInputPattern(winningLotto);
        this.winningLotto = convert(winningLotto);
        isDuplicatedWithWinningNumbers(bonusNumber);
        isValidNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
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

    private void isDuplicatedWithWinningNumbers(int bonusNumber) {
        if (this.winningLotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_DUPLICATED_WITH_WINNING_NUMBER);
        }
    }

    private void isValidNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }
}
