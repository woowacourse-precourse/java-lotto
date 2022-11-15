package lotto.domain;

import java.util.Arrays;

import net.bytebuddy.description.annotation.AnnotationList.Empty;

public enum LottoRank {
    FIRST(6, 0), SECOND(5, 1), THIRD(5, 0), FOURTH(4, 0), FIFTH(3, 0);

    private final int win;
    private final int bonus;

    LottoRank(int win, int bonus) {
        this.win = win;
        this.bonus = bonus;
    }

    public static LottoRank findByWinAndBonus(int win, int bonus) {
        LottoRank[] lottoRanks = LottoRank.values();
        LottoRank lottoRank = null;
        for (LottoRank rank : lottoRanks) {
            if (rank.getWin() == win && rank.getBonus() == bonus) {
                lottoRank = rank;
            }
        }
        return lottoRank;
    }

    public String getRank() {
        return this.name();
    }

    public int getWin() {
        return this.win;
    }

    public int getBonus() {
        return this.bonus;
    }
}
