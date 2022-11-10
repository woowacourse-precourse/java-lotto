package lotto.domain.model;

public class LottoNumber {
    private final FirstPlace firstPlace;
    private final Bonus bonus;

    public LottoNumber(final String firstPlace, final String bonus) {
        this.firstPlace = new FirstPlace(firstPlace);
        this.bonus = new Bonus(Integer.parseInt(bonus));
    }
}
