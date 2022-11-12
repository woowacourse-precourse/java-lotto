package lotto;

public class BonusLotto {
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;

    private final Lotto lotto;
    private final int bonus;

    public BonusLotto(Lotto lotto, int bonus) {
        if (lotto.checkBonus(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호랑 중복될 수 없어요.");
        }
        checkLottoRange(bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public int match(Lotto lotto) {
        return lotto.count(this.lotto);
    }

    public boolean checkBonus(Lotto lotto) {
        return lotto.checkBonus(bonus);
    }

    private void checkLottoRange(int bonus) {
        if (bonus < LOTTO_START || bonus > LOTTO_END) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자 1 ~ 45 를 입력해 주세요.");
        }
    }
}
