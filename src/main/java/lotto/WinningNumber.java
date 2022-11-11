package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateNumbersRange(winningNumbers);
        validateNumberRange(bonusNumber);
        validateContainsInWinningNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getHitCount(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(lotto::isContain)
                .count();
    }

    public boolean isHitBonusNumber(Lotto lotto) {
        return lotto.isContain(bonusNumber);
    }

    public LottoRank getRank(Lotto lotto) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.equal(getHitCount(lotto), isHitBonusNumber(lotto)))
                .findAny().orElse(LottoRank.NOTHING);
    }

    public List<LottoRank> getRanks(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::getRank)
                .collect(Collectors.toList());
    }

    public int getTotalPrizeMoney(List<LottoRank> ranks) {
        return ranks.stream()
                .mapToInt(LottoRank::getPrizeMoney)
                .sum();
    }

    public double getRateOfReturn(int money, int prizeMoney) {
        return ((double) prizeMoney / money) * 100;
    }

    private void validateNumbersRange(List<Integer> winningNumbers) {
        winningNumbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validateContainsInWinningNumber(List<Integer> winningNumber, int number) {
        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_BONUS_NUMBER.getMessage());
        }
    }
}
