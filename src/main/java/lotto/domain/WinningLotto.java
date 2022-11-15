package lotto.domain;

import java.util.List;

public class WinningLotto {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplication(lotto,bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int num) {
        if (num < MIN_RANGE || num > MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplication(Lotto lotto, int bonusNumber) {
        if(lotto.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또번호와 중복이 없어야 합니다.");

        }
    }

    public Rank match(Lotto userLotto){
        int matchCount = userLotto.getMatchCount(this.lotto);
        return Rank.findByCountAndBonus(matchCount, userLotto.hasNumber(this.bonusNumber));
    }
}
