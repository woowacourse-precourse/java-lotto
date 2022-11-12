package lotto.domain.result;

import lotto.domain.result.Result;

import java.util.List;

public class ResultMaker {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public ResultMaker(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers= winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Result getTheResult(List<Integer> lottoNumbers) {
        int accordedNumbers = (int)winningNumbers.stream()
                .filter(num -> lottoNumbers.contains(num))
                .count();
        boolean isHitBonus = lottoNumbers.contains(bonusNumber);
        return new Result(accordedNumbers, isHitBonus);
    }
}
