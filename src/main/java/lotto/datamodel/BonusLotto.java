package lotto.datamodel;

import java.util.List;

public class BonusLotto {
    private final int bonusNumber;

    public BonusLotto(int number, List<Integer> winnumbers) {
        reduplication(number, winnumbers);
        range(number);
        this.bonusNumber = number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
    private void reduplication(int number, List<Integer> winnumbers) {
        if (winnumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복이 되지 않아야 합니다.");
        }
    }

    private void range(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1-45 사이여야 합니다.");
        }
    }
}
