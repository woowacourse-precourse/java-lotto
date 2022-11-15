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
        String expression = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";
        if (!String.valueOf(bonus).matches(expression)) {
            throw new IllegalArgumentException("[ERROR] 1~45의 범위의 숫자만 입력해주세요.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}
