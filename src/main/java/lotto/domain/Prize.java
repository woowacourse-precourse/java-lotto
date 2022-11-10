package lotto.domain;

public enum Prize{
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    LAST(0);

    private final int prize;
    private Prize(int prize){
        this.prize = prize;
    }

    public int getPrize(){
        return this.prize;
    }
}