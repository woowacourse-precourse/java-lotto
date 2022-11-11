package lotto.domain;

public class WinLotto {

    private static final int MAX = 45;
    private static final int MIN = 1;

    private final Lotto lotto;
    private final int bonus;

    public WinLotto(Lotto winLotto, int bonus) {
        validate(winLotto, bonus);
        validateBonus(bonus);
        this.bonus = bonus;
        this.lotto = winLotto;
    }

    public static WinLotto of(Lotto winLotto, int bonus) {
        return new WinLotto(winLotto, bonus);
    }

    private void validate(Lotto winLotto, int bonus) {
        if (winLotto.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 보너스번호와 중첩될수 없습니다.");
        }
    }

    private void validateBonus(int bonus) {
        if (bonus > MAX || bonus < MIN) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 45보다 크거나 1보다 작을수 없습니다.");
        }
    }

    public Lotto get() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }

    public boolean contains(Integer number) {
        return lotto.contains(number);
    }
}
