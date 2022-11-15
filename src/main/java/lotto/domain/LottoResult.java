package lotto.domain;

public enum LottoResult {
    THREE(5_000),
    FOUR(50_000),
    FIVE(1_500_000),
    FIVE_BONUS(30_000_000),
    SIX(2_000_000_000),
    LOSING(0);

    private final int prize;

    LottoResult(int prize){
        this.prize = prize;
    }

    public int getPrize(){
        return prize;
    }
}
