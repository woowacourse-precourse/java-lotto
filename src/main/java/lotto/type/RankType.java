package lotto.type;

public enum RankType {
    NOTHING(0, 0, "일치하는 수가 없음"),
    FIFTH(5000, 5, "3개 일치"),
    FOURTH(50000, 4, "4개 일치"),
    THIRD(1500000, 3, "5개 일치"),
    SECOND(30000000, 2, "5개 일치, 보너스 볼 일치"),
    FIRST(2000000000, 1, "6개 일치");

    private int prizeMoney;
    private int rank;
    private String result;

    RankType(int prizeMoney, int rank, String result) {
        this.prizeMoney = prizeMoney;
        this.rank = rank;
        this.result = result;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    public Integer getRank() {
        return rank;
    }

    public String getResult() {
        return result;
    }

    public static RankType setRankType(int count, boolean isBonusBallContain) {
        if(count == 6) {
            return RankType.FIRST;
        }
        if (count == 5) {
            if(isBonusBallContain) {
                return RankType.SECOND;
            }
            return RankType.THIRD;
        }
        if(count == 4) {
            return RankType.FOURTH;
        }
        if(count == 3) {
            return RankType.FIFTH;
        }
        return RankType.NOTHING;
    }
}
