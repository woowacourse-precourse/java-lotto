package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoMachine {
    private WinningNumber winningNumber;

    public LottoMachine(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public WinningLotto isWinningLotto(Lotto lotto) {
        Integer winningNumberCount = getWinningNumberCount(lotto);
        List<Integer> lottoNumbers = lotto.getNumbers();
        int bonusNumber = winningNumber.getBonusNumber();
        return WinningLotto.from(winningNumberCount, lottoNumbers.contains(bonusNumber));
    }

    private Integer getWinningNumberCount(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.stream()
                .filter(number -> this.winningNumber.getWinningNumber().stream().anyMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList()).size();

    }
}
