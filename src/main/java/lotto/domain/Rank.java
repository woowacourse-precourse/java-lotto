package lotto.domain;

public enum Rank {
    FIRST(6, 2000000000), SECOND(5, 30000000), THIRD(5, 1500000), FOURTH(4, 50000), FIFTH(3, 5000);

    private final int value;
    private final int lottoMoney;
    private static final Rank[] RANK_DIR = Rank.values();

    Rank(int value, int lottoMoney) {
        this.value = value;
        this.lottoMoney = lottoMoney;
    }

    public int getValue() {
        return value;
    }

    public int getLottoMoney() {
        return lottoMoney;
    }

    public static String of(int count){
        for(Rank rank : RANK_DIR){
            if(rank.getValue()==count){
                return rank.name();
            }
        }
        return null;
    }
}
