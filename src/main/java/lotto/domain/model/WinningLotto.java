package lotto.domain.model;

import java.util.List;

public class WinningLotto {
    private final Lotto firstPlace;
    private final Bonus bonus;

    public WinningLotto(final String firstPlace, final String bonus) {
        this.firstPlace = new Lotto(firstPlace);
        this.bonus = new Bonus(Integer.parseInt(bonus));
    }

    public WinningLotto(final Lotto firstPlace, Bonus bonus) {
        this.firstPlace = firstPlace;
        this.bonus = bonus;
    }

    public LottoRank calculateMatch(final List<Integer> numbers) {
        return LottoRank.of(
                this.firstPlace.calculateMatch(numbers), this.bonus.calculateMatch(numbers));
    }
}
