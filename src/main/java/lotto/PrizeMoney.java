package lotto;

public enum PrizeMoney {
    ONE("ONE", 5000),
    TWO("TWO",50000),
    THREE("THREE", 1500000),
    FOUR("FOUR",2000000000),
    FIVE("FIVE",30000000)
    ;

    private String name;
    private int prize;

    PrizeMoney(String name, int prize) {
        this.name = name;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

}