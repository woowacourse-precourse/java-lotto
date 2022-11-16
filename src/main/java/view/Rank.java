package view;

public enum Rank {
    Five("3개 일치 (5,000원)", 5000),
    Four("4개 일치 (50,000원)", 50000),
    Three("5개 일치 (1,500,000원)", 1500000),
    Two("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    One("6개 일치 (2,000,000,000원)", 2000000000);

    private final String print;

    private final int prize;

    Rank(String print, int prize) {
        this.print = print;
        this.prize = prize;
    }

    public String getPrint() {
        return print;
    }
    public int getPrize() {
        return prize;
    }
}
