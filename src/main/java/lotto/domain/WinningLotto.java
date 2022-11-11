package lotto.domain;

import java.util.List;

import static lotto.domain.LottoGenerator.LOTTO_NUMBER_COUNT;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("중복된 당첨 번호가 존재합니다.");
        }
    }

    public Rank match(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchCount = countMatchNumbers(lottoNumbers);
        if (isFirstPlace(matchCount) && isContainingBonusNumber(lottoNumbers)) {
            return Rank.SECOND;
        }
        return Rank.from(matchCount);
    }

    private boolean isFirstPlace(int matchCount) {
        return matchCount == LOTTO_NUMBER_COUNT;
    }

    private boolean isContainingBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    private int countMatchNumbers(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(number -> this.getNumbers().contains(number))
                .count();
    }
}
