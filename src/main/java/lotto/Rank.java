package lotto;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5,3_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5000);


    private final int prize;
    private final int winNum;

    Rank(int winNum, int prize) {
        this.prize = prize;
        this.winNum = winNum;
    }

    //개수로 랭크 판별
}
