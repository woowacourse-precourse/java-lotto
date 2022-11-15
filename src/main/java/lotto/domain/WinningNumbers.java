package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.BonusNumberException;
import lotto.exception.WinningNumbersException;
import lotto.view.InputView;

public class WinningNumbers {

    public static final String SEPARATE_REGEX = ",";
    public static final String CHECK_UNIQUE_ERROR_MESSAGE = "[ERROR] 당첨 숫자에 보너스 숫자가 중복됩니다.";

    private Lotto winningNumbers;

    private Integer bonusNumber;

    public WinningNumbers() {
        this.winningNumbers = new Lotto(getWinningNumbersByInput());
        this.bonusNumber = getBonusNumberByInput();
        checkUnique();
    }

    public WinningNumbers(Lotto winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void checkUnique() {
        if (winningNumbers.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(CHECK_UNIQUE_ERROR_MESSAGE);
        }
    }

    public List<Integer> getWinningNumbersByInput() {
        String winningNumbersInput = InputView.winningNumbersInput();
        WinningNumbersException.checkWinningNumbers(winningNumbersInput);
        return stringToIntegerList(winningNumbersInput);
    }

    private List<Integer> stringToIntegerList(String input) {
        return Arrays.stream(input.split(SEPARATE_REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer getBonusNumberByInput() {
        String bonusNumberInput = InputView.bonusNumberInput();
        BonusNumberException.checkBonusNumber(bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }

    public List<Ranking> calculateRanking(Lottos userLottos) {
        return userLottos.compareLotto(winningNumbers, bonusNumber);
    }
}
