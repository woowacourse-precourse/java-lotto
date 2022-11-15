package lotto.Model;

import java.util.List;

public class LuckyLotto extends Lotto {
    private int bonusNumber;

    public LuckyLotto(List<Integer> luckyNumber, int bonusNumber) {
        super(luckyNumber);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위를 벗어나는 값을 입력할 수 없습니다.");
        }
        for (int n : super.getLottoNumbers()) {
            if (bonusNumber == n) {
                throw new IllegalArgumentException("[ERROR] 기존 당첨 번호와 중복된 숫자를 입력할 수 없습니다.");
            }
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
