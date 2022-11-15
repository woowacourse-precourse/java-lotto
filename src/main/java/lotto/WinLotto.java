package lotto;

public class WinLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = userLotto.countMatch(lotto);
        boolean matchBonus = userLotto.containNumber(bonusNo);
        return Rank.valueOf(countOfMatch, matchBonus);
    }

}