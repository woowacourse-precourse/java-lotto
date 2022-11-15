package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto {
    private static final String BONUS_NUMBER_RANGE_ERROR = "[ERROR] 보너스 숫자의 범위가 1~45사이가 아닙니다.";
    private static final String EXIST_BONUS_NUMBER_ERROR = "[ERROR] 보너스 숫자가 이미 당첨번호에 속해있습니다.";
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(EXIST_BONUS_NUMBER_ERROR);
        }
    }

    public Rank computeRank(Lotto lotto) {
        int matchingLottoNumbersCount = countMatchingLottoNumbers(lotto);
        boolean hasBonusNumber = matchBonusNumber(lotto);
        return Rank.of(matchingLottoNumbersCount, hasBonusNumber);
    }

    private int countMatchingLottoNumbers(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        int countMatching = 0;

        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                countMatching += 1;
            }
        }
        return countMatching;
    }

    private boolean matchBonusNumber(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        return lottoNumbers.contains(this.bonusNumber);
    }
}