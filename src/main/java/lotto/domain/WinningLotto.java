package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        isValidBonusNumber(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void isValidBonusNumber(Lotto lottoNumbers, int bonusNumber) {
        if(!isLottoRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_NOT_VALID_RANGE.getMessage());
        }
        if (!isNotDuplicatedNumber(lottoNumbers.getNumbers(), bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_DUPLICATED.getMessage());
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private boolean isLottoRange(int bonusNumber) {
        return 1 <= bonusNumber && bonusNumber <= 45;
    }

    private boolean isNotDuplicatedNumber(List<Integer> lottoNumbers, int bonusNumber) {
        lottoNumbers.add(bonusNumber);
        return (new HashSet<>(lottoNumbers)).size() == 7;
    }
}