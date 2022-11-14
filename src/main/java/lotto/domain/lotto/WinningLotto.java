package lotto.domain.lotto;

public class WinningLotto {

    private Lotto numbers;
    private int bonus;

    public WinningLotto(Lotto numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }
}
