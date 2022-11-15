package lotto.Model;

import java.util.List;

public class Winning {
    private final Lotto firstPlace;
    private final Bonus bonus;

    public Winning(final Lotto firstPlace, Bonus bonus) {
        this.firstPlace = firstPlace;
        this.bonus = bonus;
    }

    public Rank calculateMatch(final List<Integer> numbers) {
        return Rank.of(
                this.firstPlace.calLotto(numbers), this.bonus.calMatch(numbers));
    }
}