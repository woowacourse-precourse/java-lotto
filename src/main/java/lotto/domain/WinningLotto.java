package lotto.domain;

import lotto.util.Validation;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        Validation.validateDuplicates(winningNumbers,bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Prize getPrize(Lotto lottos){
        int matchedNumbers = winningNumbers.countMatchedNumbers(lottos);
        boolean bonusNumberMatched = lottos.contains(bonusNumber);
        return Prize.getPrize(matchedNumbers,bonusNumberMatched);
    }
}
