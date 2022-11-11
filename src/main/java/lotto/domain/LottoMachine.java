package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoMachine {
    private List<Integer> winningNumber;
    private Integer bonusNumber;

    public LottoMachine(List<Integer> winningNumber, Integer bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto isWinningLotto(Lotto lotto) {
        Integer winningNumberCount = getWinningNumberCount(lotto);
        List<Integer> lottoNumbers = lotto.getNumbers();
        return WinningLotto.from(winningNumberCount, lottoNumbers.contains(bonusNumber));
    }

    private Integer getWinningNumberCount(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.stream().filter(number -> winningNumber.stream().anyMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList()).size();

    }
}
