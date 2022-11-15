package util;

import domain.Lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static util.Constant.DEFAULT_ZERO;

public enum LottoRank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    LOSING_TICKET(0, false, 0);

    private final int sameCount;
    private final boolean needBonusBall;
    private final int prizeMoney;

    LottoRank(int sameCount, boolean isNeedBonusBall, int prizeMoney) {
        this.sameCount = sameCount;
        this.needBonusBall = isNeedBonusBall;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank getRank(Lotto lotto, int numberOfSameNumber, int bonusNumber) {
        if (isThird(numberOfSameNumber, lotto.isContainBonusNumber(bonusNumber))) {
            return LottoRank.THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.getSameCount() == numberOfSameNumber)
                .findAny()
                .orElse(LottoRank.LOSING_TICKET);
    }

    private static boolean isThird(int numberOfSameNumber, boolean hasBonusNumber) {
        if (SECOND.getSameCount() == numberOfSameNumber && !hasBonusNumber) {
            return true;
        }
        return false;
    }

    public static Stream<LottoRank> getAscendRank() {
        return Arrays.stream(LottoRank.values())
                .sorted(Collections.reverseOrder()).filter(rank -> rank.getPrizeMoney() != DEFAULT_ZERO);
    }

    public int getSameCount() {
        return sameCount;
    }

    public boolean isNeedBonusBall() {
        return needBonusBall;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
