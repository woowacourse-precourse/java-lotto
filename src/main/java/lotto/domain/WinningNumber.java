package lotto.domain;

public class WinningNumber {
    private final Lotto lotto;
    private final Bonus bonus;

    public WinningNumber(String numbers, int bonus) {
        this(new Lotto(numbers), bonus);
    }

    public WinningNumber(Lotto lotto, int bonus) {
        this(lotto, new Bonus(bonus));
    }

    public WinningNumber(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Ranking compare(Lotto other) {
        return Ranking.from(
                lotto.compare(other),
                other.contains(bonus.getNumber())
        );
    }
}
