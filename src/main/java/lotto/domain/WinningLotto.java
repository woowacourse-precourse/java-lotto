package lotto.domain;

import static lotto.validator.NumberValidator.validateLottoNumberRange;

public class WinningLotto {
    private final static String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 숫자는 입력할 수 없습니다.";
    private final Lotto winningLotto;
    private final int bonus;

    public WinningLotto(Lotto winningLotto, int bonus) {
        validateDuplicateBonus(winningLotto, bonus);
        validateLottoNumberRange(bonus);

        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    private void validateDuplicateBonus(Lotto numbers, int bonus) {
        if (numbers.isContain(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public Rank oneCompare(Lotto lotto) {
        return Rank.getRankByMatchCount(lotto.matchCount(winningLotto), lotto.isContain(bonus));
    }

    @Override
    public String toString() {
        return "WinningLottoNumbers{" +
                "winningLotto=" + winningLotto +
                ", bonus=" + bonus +
                '}';
    }
}