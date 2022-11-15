package lotto.domain;

public enum LottoRank {
    FIRST_RANK(1, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND_RANK(2, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_RANK(3, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH_RANK(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH_RANK(5, 5_000, "3개 일치 (5,000원)");

    private final int rankNumber;
    private final String rankMessage;
    private final int rankMoney;

    LottoRank(int rankNumber, int rankMoney ,String rankMessage) {
        this.rankNumber = rankNumber;
        this.rankMessage = rankMessage;
        this.rankMoney = rankMoney;
    }

    public static LottoRank scoreRankNumber(int sameLottoNumber) {
        if (sameLottoNumber <= 2) {
            return null;
        }
        if (sameLottoNumber == 3) {
            return FIFTH_RANK;
        }
        if (sameLottoNumber == 4) {
            return FOURTH_RANK;
        }
        if (sameLottoNumber == 5) {
           return THIRD_RANK;
        }
        if (sameLottoNumber == 6) {
            return FIRST_RANK;
        }
        return null;
    }

    public int getRankNumber() {
        return rankNumber;
    }

    public int getRankMoney() {
        return rankMoney;
    }

    public String getRankMessage() {
        return rankMessage;
    }
}
