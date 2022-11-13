package lotto;

//- 1등: 6개 번호 일치 / 2,000,000,000원
//- 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
//- 3등: 5개 번호 일치 / 1,500,000원
//- 4등: 4개 번호 일치 / 50,000원
//- 5등: 3개 번호 일치 / 5,000원
public enum Prize {
    FIRST(6, 2_000_000_000, "2,000,000,000원"),
    SECOND(5, 30_000_000, "30,000,000원"),
    THIRD(5, 1_500_000, "1,500,000원"),
    FOURTH(4, 50_000, "50,000원"),
    FIFTH(3, 5_000, "5,000원"),
    NOTHING(0, 0, "0원");

    private int matchCount;
    private int prizeMoney;
    private String prizeString;

    private Prize(int matchCount, int prizeMoney, String prizeString) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.prizeString = prizeString;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizeString() {
        return prizeString;
    }

    public static Prize getPrize(int matchCount, boolean matchBonus) {
        if (matchCount == FIRST.matchCount) {
            return FIRST;
        } else if (matchCount == SECOND.matchCount && matchBonus) {
            return SECOND;
        } else if (matchCount == THIRD.matchCount) {
            return THIRD;
        } else if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        } else if (matchCount == FIFTH.matchCount) {
            return FIFTH;
        }
        return NOTHING;
    }
}
