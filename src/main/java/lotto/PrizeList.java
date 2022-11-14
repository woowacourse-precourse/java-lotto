package lotto;

public enum PrizeList {
    FIRST(2000000000), SECOND(30000000), THIRD(1500000), FOURTH(50000), FIFTH(5000);
    private final int money;
    PrizeList(int money){
        this.money = money;
    }
    public int money(){
        return  money;
    }
}
