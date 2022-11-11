package lotto.model;

import java.util.List;

public class LottoDrawingMachine {

    public static final int LOTTO_RANGE_MIN = 1;
    public static final int LOTTO_RANGE_MAX = 45;
    private Lotto winningLotto;
    private Integer bonusNumber;

    public void draw(List<Integer> winningNumbers, Integer bonusNumber) {
        winningLotto = new Lotto(winningNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if (bonusNumber < LOTTO_RANGE_MIN || bonusNumber > LOTTO_RANGE_MAX) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45까지여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
