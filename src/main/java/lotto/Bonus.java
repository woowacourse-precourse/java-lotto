package lotto;

import static util.Constant.*;

import java.util.List;

public class Bonus {

    private int bonus;

    public Bonus(List<Integer> lotto, int bonus) {
        validateNumBetween1And45(bonus);
        validateLottoConsistOfBonus(lotto, bonus);
        this.bonus = bonus;
    }

    // 보너스 번호가 1과 45 사이의 수로 구성되어 있는지 검증하는 기능
    private void validateNumBetween1And45(int bonus) {
        if(!(LOTTO_MIN_NUM <=bonus && bonus <= LOTTO_MAX_NUM)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 보너스 번호 입니다.");
        }
    }

    // 보너스 번호가 lotto 번호에 포함되는지 검증하는 기능
    private void validateLottoConsistOfBonus(List<Integer> lotto, int bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호 이외의 숫자이어야 합니다.");
        }
    }

}
