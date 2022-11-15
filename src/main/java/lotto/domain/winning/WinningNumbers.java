package lotto.domain.winning;


import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {

    private static final int TOTAL_NUMBER_SIZE = 7;
    private static final int WINNING_NUMBER_SIZE = 6;

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusWinningNumber;

    public WinningNumbers(List<Integer> numbers, int bonusWinningNumber) {
        validate(numbers, bonusWinningNumber);
        this.winningNumbers = generateWinningNumbers(numbers);
        this.bonusWinningNumber = generateBonusWinningNumber(bonusWinningNumber);
    }

    private List<LottoNumber> generateWinningNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private LottoNumber generateBonusWinningNumber(int bonusWinningNumber) {
        return new LottoNumber(bonusWinningNumber);
    }

    private void validate(List<Integer> numbers, int bonusWinningNumber) {
        validateSize(numbers);
        validateDuplication(numbers, bonusWinningNumber);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 총 개수가 6이 아닙니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers, int bonusWinningNumber) {
        Set<Integer> numberSet = new HashSet<>(numbers);

        numberSet.add(bonusWinningNumber);

        if (numberSet.size() != TOTAL_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 존재합니다.");
        }
    }

    public WinningRank check(Lotto lotto) {
        int count = countMatches(lotto);
        boolean hasBonus = checkMatchBonus(lotto);

        return WinningRank.of(count, hasBonus);
    }

    private int countMatches(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(lotto::isSame)
                .count();
    }

    private boolean checkMatchBonus(Lotto lotto) {
        return lotto.isSame(bonusWinningNumber);
    }
}
