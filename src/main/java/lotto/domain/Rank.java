package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, false, 0, ""),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - ${number}개"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - ${number}개"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - ${number}개"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ${number}개"),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - ${number}개");

    private final int matchNumber;
    private final boolean hasBonusNumber;
    private final int WinningPrice;
    private final String matchMessage;

    Rank(int matchNumber, boolean hasBonusNumber, int WinningPrice, String matchMessage) {
        this.matchNumber = matchNumber;
        this.hasBonusNumber = hasBonusNumber;
        this.WinningPrice = WinningPrice;
        this.matchMessage = matchMessage;
    }

    public static Rank findRank(int matchNumber, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> (rank.matchNumber == matchNumber))
                .filter(rank -> (rank.hasBonusNumber == hasBonusNumber))
                .findAny()
                .orElse(NOTHING);
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }

    public int getWinningPrice() {
        return WinningPrice;
    }

    public String getMatchMessage() {
        return matchMessage;
    }
}
