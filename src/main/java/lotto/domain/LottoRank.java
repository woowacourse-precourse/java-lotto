package lotto.domain;

public enum LottoRank {
    FIRST_RANK(1, "6개 일치 (2,000,000,000원)"),
    SECOND_RANK(2, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_RANK(3, "5개 일치 (1,500,000원)"),
    FOURTH_RANK(4, "4개 일치 (50,000원)"),
    FIFTH_RANK(5, "3개 일치 (5,000원)");

    private final int rankNumber;
    private final String rankMessage;

    LottoRank(int rankNumber, String rankMessage) {
        this.rankNumber = rankNumber;
        this.rankMessage = rankMessage;
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

    public String getRankMessage() {
        return rankMessage;
    }
}
