package lotto;

import java.text.DecimalFormat;

public enum LottoRanking {
    FIRST(6, "6개 일치", 2000000000),
    SECOND(5, "5개 일치, 보너스 볼 일치", 30000000),
    THIRD(5, "5개 일치", 1500000),
    FOURTH(4, "4개 일치", 50000),
    FIFTH(3, "3개 일치", 5000),
    NONE(0, "낙첨", 0);

    private final int matches;
    private final int lottoRankingMoney;
    private final String description;

    LottoRanking(int matches, String description, int rankingMoney) {
        this.matches = matches;
        this.description = description;
        this.lottoRankingMoney = rankingMoney;
    }

    public LottoRanking getPrize(int matches) {
        LottoRanking[] val = values();
        for (LottoRanking lottoRanking : val) {
            if (lottoRanking.matches == matches)
                return lottoRanking;
        }
        return LottoRanking.NONE;
    }

    public int getLottoRankingMoney() {
        return lottoRankingMoney;
    }

    public String getDescription() {
        DecimalFormat commaBy000 = new DecimalFormat("#,###");

        String str = this.description + " (" + commaBy000.format(this.lottoRankingMoney) + "원)";
        return str;
    }
}
