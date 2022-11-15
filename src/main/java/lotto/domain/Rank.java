package lotto.domain;

public enum Rank {

    FIRST(6,2_000_000_000, false),
    SECOND(5,30_000_000,true),
    THIRD(5, 1_500_000,false),
    FOURTH(4,  50_000, false),
    FIFTH(3,  5_000,false),
    OTHER(0, 0,false),
    ;

    private Integer winningCount;
    private Integer price;
    private boolean isSecond;

    Rank(int winningCount, int price, boolean isSecond) {
        this.winningCount = winningCount;
        this.price = price;
        this.isSecond = isSecond;
    }
}
