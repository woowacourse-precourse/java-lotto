package lotto.domain;

import java.util.List;

public class JackpotBonus {
    private static final String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
    private final List<Integer> jackpotNumbers;
    private final int bonusNumber;

    public JackpotBonus(List<Integer> jackpotNumbers, int bonusNumber) {
        this.jackpotNumbers = jackpotNumbers;

        validateBonusNumber(jackpotNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private static void validateBonusNumber(List<Integer> jackpotNumbers, int bonusNumber) throws IllegalArgumentException {
        if (jackpotNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public Rank getRankOf(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int jackpotCnt = countJackpot(lottoNumbers);
        boolean hasBonus = hasBonus(lottoNumbers);

        return Rank.getInstanceOf(jackpotCnt, hasBonus);
    }

    private int countJackpot(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(jackpotNumbers::contains)
                .count();
    }

    private boolean hasBonus(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
