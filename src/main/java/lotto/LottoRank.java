package lotto;

public enum LottoRank {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final int lottoReward;

    LottoRank(int lottoReward){
        this.lottoReward = lottoReward;
    }

    public int getLottoReward(){
        return lottoReward;
    }
}
