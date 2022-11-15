package lotto;

public enum WinStatus {

    LOSING(0,0,false),
    FIFTH(5000,3,false),
    FOURTH(50000,4,false),
    THIRD(1500000,5,,false),
    SECOND(30000000,5,true),
    FIRST(2000000000,6,false);
    private final int price;
    private final int match;
    private final boolean bonus;
    WinStatus(int price, int match,boolean bonus){
        this.price = price;
        this.match = match;
        this.bonus = bonus;
    }
}
