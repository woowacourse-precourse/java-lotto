package lotto.enums;

public enum LottoRank {
    FIFTH(3, "5,000", "3개 일치"),
    FOURTH(4, "50,000", "4개 일치"),
    THIRD(5, "1,500,000", "5개 일치"),
    SECOND(5, "30,000,000", "5개 일치, 보너스 볼 일치"),
    FIRST(6, "2,000,000,000", "6개 일치");

    private int lottoCount;
    private String price;
    private String rank;

    public static String getPrice(LottoRank lottoRank) {
        return lottoRank.price;
    }

    public static String getRank(LottoRank lottoRank) {
        return lottoRank.rank;
    }

    LottoRank(int lottoCount, String price, String rank) {
        this.lottoCount = lottoCount;
        this.price = price;
        this.rank = rank;
    }

    public static LottoRank valueOf(int lottoCount, int bonusNumber) {
        if (lottoCount == LottoRank.SECOND.lottoCount) {
            return checkBonusNumber(bonusNumber);
        }

        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.lottoCount == lottoCount) {
                return lottoRank;
            }
        }

        return null;  // or throw exception
    }

    public static LottoRank checkBonusNumber(int bonusNumber) {
        if (bonusNumber == 1) {
            return LottoRank.SECOND;
        }
        return LottoRank.THIRD;
    }
}
