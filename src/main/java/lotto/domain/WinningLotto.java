package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningLotto {
    private static final CanValidate<Map<Integer, Boolean>> validator = new WinningLottoValidator();
    /**
     * Key : 로또 번호
     * Value : bonus number이면 True
     */
    private final Map<Integer, Boolean> winningNumbers;

    public WinningLotto(Map<Integer, Boolean> winningNumbers) {
        validator.validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public LottoResult compare(List<Integer> numbers) {
        int normalCount = 0;
        int bonusCount = 0;

        for (int number : numbers) {
            bonusCount += addCountIfBonusNumberMatch(number);
            normalCount += addCountIfNormalNumberMatch(number);
        }

        return LottoResult.of(normalCount, bonusCount);
    }

    private int addCountIfBonusNumberMatch(Integer number) {
        if (winningNumbers.containsKey(number) && winningNumbers.get(number)) {
            return 1;
        }
        return 0;
    }

    private int addCountIfNormalNumberMatch(Integer number) {
        if (winningNumbers.containsKey(number) && !winningNumbers.get(number)) {
            return 1;
        }
        return 0;
    }

    public static WinningLotto of(Map<Integer, Boolean> winningNumbers) {
        return new WinningLotto(winningNumbers);
    }
}
