package lotto.domain.model;

import java.util.List;
import java.util.Map;

public class LottoNumber {
    private final FirstPlace firstPlace;
    private final Bonus bonus;

    public LottoNumber(final String firstPlace, final String bonus) {
        this.firstPlace = new FirstPlace(firstPlace);
        this.bonus = new Bonus(Integer.parseInt(bonus));
    }

    public LottoRank calculateMatch(final List<Integer> numbers) {
        LottoRank lottoRank = this.firstPlace.calculateMatch(numbers);
        Boolean bonusMatch = this.bonus.calculateMatch(numbers);

        if (lottoRank == LottoRank.FIVE_MATCHES && bonusMatch) {
            return LottoRank.FIVE_BONUS_MATCHES;
        }
        return lottoRank;
    }
}
