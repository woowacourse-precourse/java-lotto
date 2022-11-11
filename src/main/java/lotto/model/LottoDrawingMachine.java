package lotto.model;

import java.util.List;

public class LottoDrawingMachine {

    private Lotto winningLotto;
    private Integer bonusNumber;

    public void draw(List<Integer> winningNumbers, Integer bonusNumber) {
        winningLotto = new Lotto(winningNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
