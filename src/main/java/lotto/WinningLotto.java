package lotto;

public class WinningLotto {
    private Lotto lotto;
    private int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        validateBonus(bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validateBonus(int bonus) throws IllegalArgumentException {
        if(bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여 합니다.");
        }
        if(this.lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}
