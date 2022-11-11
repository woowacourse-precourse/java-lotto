package lotto.enums;

public enum LottoRank {
    FIFTH(3, 5000, "5등"),
    FOURTH(4, 50000, "4등"),
    THIRD(5, 1500000, "3등"),
    SECOND(5, 30000000, "2등(보너스 볼 일치)"),
    FIRST(6, 2000000000, "1등");

    private int lottoCount;
    private int price;
    private String rank;

    public static int getPrice(LottoRank lottoRank) {
        return lottoRank.price;
    }

    LottoRank(int lottoCount, int price, String rank) {
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
