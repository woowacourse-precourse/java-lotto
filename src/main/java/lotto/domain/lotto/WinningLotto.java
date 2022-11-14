package lotto.domain.lotto;

public class WinningLotto {

    private Lotto lotto;
    private int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        validateBonus(bonus);
        this.bonus = bonus;
    }

    private void validateBonus(int bonus) {
        validateBonusByDuplicatedNumber(bonus);
        validateBonusByNumberRange(bonus);
    }

    private void validateBonusByDuplicatedNumber(int bonus) {
        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 포함되어 있지 않은 숫자를 입력해주세요.");
        }
    }

    private void validateBonusByNumberRange(int bonus) {

    }


}
