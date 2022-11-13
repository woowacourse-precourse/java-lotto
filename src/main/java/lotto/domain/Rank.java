package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, 0, ""),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - ${number}개"),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - ${number}개"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - ${number}개"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ${number}개"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ${number}개");

    private final int matchNumber;
    private final int WinningPrice;
    private final String matchMessage;

    Rank(int matchNumber, int WinningPrice, String matchMessage) {
        this.matchNumber = matchNumber;
        this.WinningPrice = WinningPrice;
        this.matchMessage = matchMessage;
    }

    public static Rank findRank(int matchNumber, boolean hasBonusNumber) {
        if(hasBonusNumber && (matchNumber == SECOND.matchNumber)) {
            return SECOND;
        }

        if(!hasBonusNumber && (matchNumber == THIRD.matchNumber)) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.hasMatchedNumber(matchNumber))
                .findAny()
                .orElse(NOTHING);
    }

    private boolean hasMatchedNumber(int matchNumber) {
        return (this.matchNumber == matchNumber);
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getWinningPrice() {
        return WinningPrice;
    }

    public String getMatchMessage() {
        return matchMessage;
    }
}
