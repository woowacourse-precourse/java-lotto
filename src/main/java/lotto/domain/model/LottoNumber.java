package lotto.domain.model;

import java.util.List;

public class LottoNumber {
    private final FirstPlace firstPlace;
    private final Bonus bonus;

    public LottoNumber(final String firstPlace, final String bonus) {
        this.firstPlace = new FirstPlace(firstPlace);
        this.bonus = new Bonus(Integer.parseInt(bonus));
    }

    public LottoRank calculateMatch(final List<Integer> numbers) {
        return LottoRank.of(
                this.firstPlace.calculateMatch(numbers), this.bonus.calculateMatch(numbers));
    }
}
