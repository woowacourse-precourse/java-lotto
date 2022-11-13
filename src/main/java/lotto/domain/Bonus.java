package lotto.domain;

import java.util.List;

public class Bonus {
    private final int bonusNumber;

    public Bonus(int bonusNumber, Lotto winningLotto) {
        validateBonusDuplication(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    private static void validateBonusDuplication(Lotto winningLotto, int bonusNumber) {
        List<Integer> lottoNumbers =  winningLotto.getLotto();
        if (lottoNumbers.contains(bonusNumber)) {
            System.out.println("[ERROR} 보너스 번호는 담첨 번호에 포함될 수 없습니다.");
            throw new IllegalArgumentException("[ERROR] 잘못된 보너스 번호");
        }
    }
}
