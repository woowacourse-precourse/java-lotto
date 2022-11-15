package lotto;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNo;

    public WinningLotto(Lotto lotto, LottoNumber bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = userLotto.countOfMatch(lotto);
        boolean matchBonus = userLotto.isContains(bonusNo);
        return Rank.findByCountOfMatchAndMatchBonus(countOfMatch, matchBonus);
    }
}
