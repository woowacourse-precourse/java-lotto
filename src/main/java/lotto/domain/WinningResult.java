package lotto.domain;

import java.util.List;

public class WinningResult {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningResult(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers= winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Result checkTheResult(List<Integer> lottoNumbers) {
        int accordedNumbers = (int)winningNumbers.stream()
                .filter(num -> lottoNumbers.contains(num))
                .count();
        boolean isHitBonus = lottoNumbers.contains(bonusNumber);
        return new Result(accordedNumbers, isHitBonus);
    }
}
