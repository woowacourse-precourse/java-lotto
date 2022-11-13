package lotto.utility;

public enum LottoRanking {
    CORRECT3(0,5000),
    CORRECT4(1,50000),
    CORRECT5(2,1500000),
    CORRECT5BONUS1(3,30000000),
    CORRECT6(4,2000000000);

    private final int value;
    private final int price;

    private LottoRanking(int value, int price){
        this.value = value;
        this.price = price;
    }

    public int getValue(){
        return this.value;
    }

    public int getPrice(){
        return this.price;
    }
}