package lotto.domain;

public enum Rank {
    FIFTH(3, "3개 일치 (5,000원)", 5000)
    , FOURTH(4, "4개 일치 (50,000원)", 50000)
    , THIRD(5, "5개 일치 (1,500,000원)", 1500000)
    , SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000)
    , FIRST(6, "6개 일치 (2,000,000,000원)", 2000000000);

    private final int value;
    private final String ouputMessage;
    private final int lottoMoney;
    private static final Rank[] RANK_DIR = Rank.values();

    Rank(int value, String ouputMessage, int lottoMoney) {
        this.value = value;
        this.ouputMessage = ouputMessage;
        this.lottoMoney = lottoMoney;
    }

    public int getValue() {
        return value;
    }

    public String ouputMessage() {
        return ouputMessage;
    }

    public int getLottoMoney() {
        return lottoMoney;
    }

    public static String of(int count) {
        for (Rank rank : RANK_DIR) {
            if (rank.getValue() == count) {
                return rank.name();
            }
        }
        return null;
    }
}
