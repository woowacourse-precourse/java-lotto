package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final String DUPLICATE_NUMBER_ERROR = "[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.";
    public final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;

    }

    public void validateDuplicateNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }

    private int countHitNumber(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> winningNumbers.stream().anyMatch(Predicate.isEqual(lottoNumber)))
                .count();
    }

    public LottoRank calculrateRank(List<Integer> lotto) {
        int hitCount = countHitNumber(lotto);
        boolean hasBonus = lotto.contains(bonusNumber);
        return LottoRank.valueOf(hitCount, hasBonus);
    }



}
