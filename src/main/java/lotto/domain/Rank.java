package lotto.domain;

import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0,0);

    private static final int MIN_MATCH_NUMBER = 3;

    private int matchCount;
    private int matchMoney;

    Rank(int matchCount, int matchMoney) {
        this.matchCount = matchCount;
        this.matchMoney = matchMoney;
    }

    public static Rank valueOf(Lotto lotto, int bonusNumber, int matchCount) {
        if (matchCount < MIN_MATCH_NUMBER) {
            return NONE;
        }
        if (SECOND.matchCount == matchCount && isMatchedBonusNumber(lotto, bonusNumber)) {
            return SECOND;
        }
        for (Rank value : values()) {
            if (!value.equals(SECOND) && value.matchCount == matchCount) {
                return value;
            }
        }
        return NONE;
    }

    private static boolean isMatchedBonusNumber(Lotto lotto, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        return lottoNumbers.contains(bonusNumber);
    }
}
