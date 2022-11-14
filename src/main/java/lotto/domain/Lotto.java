package lotto.domain;

import lotto.util.LottoConstant;
import lotto.util.LottoRank;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public LottoRank getRank(WinningNumber winningNumber) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.equal(getHitCount(winningNumber), isHitBonusNumber(winningNumber)))
                .findAny().orElse(LottoRank.NOTHING);
    }

    public int getHitCount(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::isContainedWinningNumber)
                .count();
    }

    public boolean isHitBonusNumber(WinningNumber winningNumber) {
        return numbers.stream()
                .anyMatch(winningNumber::isEqualToBonusNumber);
    }

    public List<Integer> getSortedByAscend() {
        return numbers.stream()
                .sorted(Comparator.comparing(Integer::valueOf))
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LottoConstant.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException();
        }
    }
}
