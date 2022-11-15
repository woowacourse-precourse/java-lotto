package lotto;

//- 1등: 6개 번호 일치 / 2,000,000,000원
//- 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
//- 3등: 5개 번호 일치 / 1,500,000원
//- 4등: 4개 번호 일치 / 50,000원
//- 5등: 3개 번호 일치 / 5,000원
public enum Prize {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - %d개"),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개"),
    NOTHING(0, 0, "");

    private int matchCount;
    private int prizeMoney;
    private String resultFormat;

    private Prize(int matchCount, int prizeMoney, String resultFormat) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.resultFormat = resultFormat;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getResultFormat(int count) {
        return String.format(resultFormat, count);
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
